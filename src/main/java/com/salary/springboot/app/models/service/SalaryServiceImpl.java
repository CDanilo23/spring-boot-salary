package com.salary.springboot.app.models.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.salary.springboot.app.models.EmployeeDTO;

@Service
public class SalaryServiceImpl implements ISalaryService{
	
	@Autowired
	private RestTemplate restClient;
	
	@Value("${api.url}")
	private String apiurl;
	
	@Value("${constants.weeks}")
	private String weeks;
	
	@Value("${constants.months}")
	private String months;
	

	/**
	 * Retrive all info of employees from azure resource
	 * Convert all those data to local DTO
	 */
	@Override
	public List<EmployeeDTO> findAll() {
		
		List<EmployeeDTO> employees = Arrays.asList(restClient.getForObject(apiurl, EmployeeDTO[].class));
		
		return calculateAnualSalary(employees);
	}
	
	/**
	 * Retrive all info of specific employee by id from azure resource 
	 */
	@Override
	public EmployeeDTO findById(int id) {
		return Optional.ofNullable(findAll().stream().filter(p -> p.getId() == id).collect(Collectors.toList()).get(0)).orElse(null);
	}
	
	/**
	 * calculate the salary throught the algorithm given
	 * return a list of employees with the data done
	 * */
	private List<EmployeeDTO> calculateAnualSalary(List<EmployeeDTO> employees) {
		
		employees.stream().forEach(emp -> {
			emp.setAnualHourlySalary(new BigDecimal(weeks).multiply(emp.getHourlySalary()).multiply(new BigDecimal(months)));
			emp.setAnualMonthlySalary(emp.getMonthlySalary().multiply(new BigDecimal(months)));
			
		});
		return employees;
	}

}
