package com.swagger.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class Employee implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty(notes = "Employee Id in number format")
	private int empId;
    
    @ApiModelProperty(notes = "Employee First Name")
	private String firstName;
	
    @ApiModelProperty(notes = "Employee Last Name")
    private String lastName;
	
    @ApiModelProperty(notes = "Employee Salary")
    private float salary;
	
	public Employee() {}
	
	
	public Employee(int empId, String firstName, String lastName, float salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}
	
	
	

}
