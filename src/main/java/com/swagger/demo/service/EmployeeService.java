package com.swagger.demo.service;


import java.util.List;

import com.swagger.demo.model.Employee;

public interface EmployeeService {	
	
	List<Employee> getAllEmployees();

	Employee getEmployeeById(Employee employee);
	
	Employee getEmployeeByFirstName(Employee employee);
	
	List<Employee> getEmployeebyFrName(Employee employee);
	
	List<Employee> getEmployeebyCondition(Employee employee);

	Employee getEmployeeByFirstNameByPathVarible(String firstName);

	
}
