package com.swagger.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.swagger.demo.model.Employee;
import com.swagger.demo.service.EmployeeService;
import com.swagger.demo.utils.HelperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	// get static employee list
	@Override
	public List<Employee> getAllEmployees() {
		return HelperUtil.getStaticEmployee();
	}

		
	

	@Override
	public Employee getEmployeeById(Employee employee) {

		List<Employee> list = getAllEmployees();
		
		for (Employee emp : list) {
			if (employee.getEmpId() == emp.getEmpId())
				return emp;
		}
		return new Employee(0, "Not Found", "Please enter valid id", 0.0f);
	}

	
	
	@Override
	public Employee getEmployeeByFirstName(Employee employee) {
	
		List<Employee> list = getAllEmployees();
		
		for (Employee emp : list) {
			if (emp.getFirstName().equals(employee.getFirstName()))
				return emp;
		}
		return new Employee(0, "Not Found", "Please enter valid name", 0.0f);
	}

	
	
	@Override
	public List<Employee> getEmployeebyFrName(Employee employee) {
	
		List<Employee> list = getAllEmployees();
		List<Employee> matchingEmps = new ArrayList<>();

		if (null != employee && null != employee.getFirstName() && !(employee.getFirstName().equals(""))) {
			for (Employee emp : list) {
				// 10000
				if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
					matchingEmps.add(emp);
				}
			}
		}
		return matchingEmps;
	}

	
	
	@Override
	public Employee getEmployeeByFirstNameByPathVarible(String firstName) {
		
		if (!StringUtils.isEmpty(firstName)) {
			
			List<Employee> list = getAllEmployees();

			for (Employee emp : list) {
				if (emp.getFirstName().equalsIgnoreCase(firstName))
					return emp;
			}
		}
		return new Employee(0, "Not Found", "Please enter valid name", 0.0f);
	}

	
	
	
	@Override
	public List<Employee> getEmployeebyCondition(Employee employee) {
	
		List<Employee> list = getAllEmployees();
		List<Employee> matchingEmps = new ArrayList<>();

		// This will return true if employee object is present(not null) any one of
		// property is not null OR greater than 0
		if (null != employee && (null != employee.getFirstName() || employee.getEmpId() > 0
				|| null != employee.getLastName() || employee.getSalary() > 0)) {

			for (Employee emp : list) {

				// If all 4 properties are present then only this block will execute
				if (null != employee.getFirstName() && employee.getEmpId() > 0 && null != employee.getLastName()
						&& employee.getSalary() > 0) {

					if (emp.getEmpId() == employee.getEmpId()
							&& emp.getFirstName().equalsIgnoreCase(employee.getFirstName())
							&& emp.getLastName().equalsIgnoreCase(employee.getLastName())
							&& emp.getSalary() == employee.getSalary()) {
						matchingEmps.add(emp);
						// Break the for loop
						break;
					} else {
						// Go back to first statement (nothing but for loop)
						continue;
					}
				}

				// if any one of above property is null or less than equals to 0 then below
				// block is executing
				// Emp Id
				if (employee.getEmpId() == emp.getEmpId()) {
					matchingEmps.add(emp);
					// Go back to first statement (nothing but for loop)
					continue;
				}

				// First name
				if (null != employee.getFirstName()) {
					if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
						matchingEmps.add(emp);
						// Go back to first statement (nothing but for loop)
						continue;
					}
				}

				// Last name
				if (null != employee.getLastName()) {
					if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
						matchingEmps.add(emp);
					// Go back to first statement (nothing but for loop)
					continue;
				}
				// salary
				if (employee.getSalary() == emp.getSalary()) {
					matchingEmps.add(emp);
					// Go back to first statement (nothing but for loop)
					continue;
				}
				// ---------------------------------------------------------
			}
			// returning the list
			return matchingEmps;
		}
		// if below statements return false only then below list is returning
		// if (null != employee &&
		// (null != employee.getFirstName() || employee.getEmpId() > 0
		// || null != employee.getLastName() || employee.getSalary() > 0))
		return matchingEmps;
	}




	
}
