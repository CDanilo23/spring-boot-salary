package com.salary.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.salary.springboot.app.models.EmployeeDTO;
import com.salary.springboot.app.models.service.ISalaryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SalaryEmployeeController {
	
	@Autowired
	private ISalaryService salaryService;

	@GetMapping("/employees")
	public List<EmployeeDTO> findAllEmployees(){
		return salaryService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public EmployeeDTO findEmployeesById(@PathVariable int id){
		return salaryService.findById(id);
	}
}
