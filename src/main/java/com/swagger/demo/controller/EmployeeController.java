package com.swagger.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.demo.model.Employee;
import com.swagger.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@RequestMapping("api")
@Api(value = "Employee details", description = "Get Employee details using Id, First name, Last name or salary")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	
	@ApiOperation(value = "Returns Hello Spring boot")
	@GetMapping("say")
	public String sayHello() {
		return "Hello Spring boot";
	}
	
	@ApiOperation(value = "Returns all static Employee data")
	@GetMapping("get-employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	
	@ApiOperation(value = "Returns Employee data by ID")
    @ApiResponses(
            value = {
            		@ApiResponse(code = 200, message = "Employee fetched successfully"),
                    @ApiResponse(code = 404, message = "Employee not found")
            }
    )
	@PostMapping("get-employee-by-id")
	public Employee getEmployee(@RequestBody Employee employee) {
		return employeeService.getEmployeeById(employee);
	}
	
	
	@ApiOperation(value = "Returns Employee data by first name as path variable")
	@GetMapping("get-employee/{firstName}")
	public Employee getEmployeeByFirstNameByPath(@PathVariable final String firstName) {
		return employeeService.getEmployeeByFirstNameByPathVarible(firstName);
	}
	
	
	@ApiOperation(value = "Delete Employee data by first name as path variable")
	@DeleteMapping("delete-employee/{firstName}")
	public ResponseEntity<String> deleteEmployeebyFirstNameByPath(@PathVariable final String firstName) {
		return new ResponseEntity<String>(firstName + "'s data deleted successfully", HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Returns Employee data by first name")
	@PostMapping("get-employee-by-firstName")
	public Employee getEmployeeByFirstName(@RequestBody Employee employee) {
		return employeeService.getEmployeeByFirstName(employee);
	}
		
	
	@ApiOperation(value = "Returns Employee list by first name")
	@PostMapping("get-employee-by-frName")
	public List<Employee> getEmployeebyFrName(@RequestBody Employee employee) {
		return employeeService.getEmployeebyFrName(employee);
	}

	
	@ApiOperation(value = "Returns Employee list by multiple condition")
	@PostMapping("get-employee-by-condition")
	public List<Employee> getEmployeebyCondition(@RequestBody Employee employee) {
		return employeeService.getEmployeebyCondition(employee);
	}
}
