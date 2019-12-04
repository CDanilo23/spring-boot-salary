package com.salary.springboot.app.models.service;

import java.util.List;

import com.salary.springboot.app.models.EmployeeDTO;

public interface ISalaryService {

	 List<EmployeeDTO> findAll() ;
	 EmployeeDTO findById(int id); 
	
}
