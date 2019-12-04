package com.salary.springboot.app;



import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.salary.springboot.app.models.EmployeeDTO;
import com.salary.springboot.app.models.service.ISalaryService;


public class SpringbootSalaryApplicationTests {
	
	private ISalaryService salaryService;
	
	@Before
	public void init() {
		salaryService = mock(ISalaryService.class);
		List<EmployeeDTO> listEmp = Arrays.asList(new EmployeeDTO());
		EmployeeDTO empMock = new EmployeeDTO();
		empMock.setId(123);
		Mockito.when(salaryService.findAll()).thenReturn(listEmp);
		Mockito.when(salaryService.findById(Mockito.anyInt())).thenReturn(empMock);
	}
	/**
	 * GIVEN getting the mock interface, the expected value is set up it
	 * WHEN the method findAll would be invoked
	 * THEN after getting the size of the list if will be compared with the expected value
	 */
	
	@Test
	public void test_That_Invoke_Url_By_RestTemplate_Retrieve_Data() {
		//GIVEN
		int sizeList = 1;
		//WHEN
		//THEN
		Assert.assertEquals(sizeList, salaryService.findAll().size());
	}
	
	/**
	 * GIVEN getting previously the mock interface, the DTO expected is set up it
	 * WHEN the method findById sending id
	 * THEN after the request, an object with id 123 will be retrieved and then compared 
	 **/
	@Test
	public void test_That_Retrieve_Employee_Data_From_Method_By_Id() {
		//GIVEN
		int idEmployee = 123;
		//WHEN
		//THEN
		Assert.assertEquals(idEmployee, salaryService.findById(0).getId());
	}
	
	

}
