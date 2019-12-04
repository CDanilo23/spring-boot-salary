package com.salary.springboot.app.models;

import java.math.BigDecimal;

public class EmployeeSalaryDTO {
	
	private BigDecimal anualHourlySalary;
	private BigDecimal anualMonthlySalary;
	
	
	public BigDecimal getAnualHourlySalary() {
		return anualHourlySalary;
	}
	public void setAnualHourlySalary(BigDecimal anualHourlySalary) {
		this.anualHourlySalary = anualHourlySalary;
	}
	public BigDecimal getAnualMonthlySalary() {
		return anualMonthlySalary;
	}
	public void setAnualMonthlySalary(BigDecimal anualMonthlySalary) {
		this.anualMonthlySalary = anualMonthlySalary;
	}
	
}
