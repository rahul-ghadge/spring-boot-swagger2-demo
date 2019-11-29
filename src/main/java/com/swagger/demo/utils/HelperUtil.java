package com.swagger.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.swagger.demo.model.Employee;

public class HelperUtil {

	private HelperUtil() {
	}

	public static List<Employee> getStaticEmployee() {

		List<Employee> list = new ArrayList<>();

		list.add(new Employee(1, "Binay", "Gurung", 3000.0f));
		list.add(new Employee(2, "Rahul", "Ghadage", 4000.0f));
		list.add(new Employee(3, "Sunny", "Deol", 5000.0f));
		list.add(new Employee(4, "Salman", "Khan", 6000.0f));
		list.add(new Employee(5, "Aamir", "Khan", 7000.0f));
		list.add(new Employee(6, "Sharukh", "Khan", 8000.0f));
		list.add(new Employee(7, "Ranbir", "Kapoor", 9000.0f));
		list.add(new Employee(8, "Ranveer", "Singh", 10000.0f));
		list.add(new Employee(9, "Akshay", "Kumar", 11000.0f));
		list.add(new Employee(10, "Ajay", "Devgan", 12000.0f));

		return list;

	}

}
