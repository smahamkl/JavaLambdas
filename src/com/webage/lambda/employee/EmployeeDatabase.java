package com.webage.lambda.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {
	public static List<Employee> createEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee("Bob", "Baker", Role.STAFF, "Eng", "MO", 40000.0));
		employees.add(new Employee("Jane", "Doe", Role.STAFF, "Sales", "AZ", 47000.0));
		employees.add(new Employee("John", "Thompson", Role.MANAGER, "HR", "MO", 60000.0));
		employees.add(new Employee("James", "Johnson", Role.MANAGER, "Eng", "CT", 86000.0));
		employees.add(new Employee("John", "Adams", Role.MANAGER, "Sales", "AZ", 93000.0));
		employees.add(new Employee("Joe", "Bailey", Role.EXECUTIVE, "Eng", "CT", 120000.0));
		employees.add(new Employee("Phil", "Smith", Role.EXECUTIVE, "HR", "CT", 110000.0));
		employees.add(new Employee("Betty", "Jones", Role.EXECUTIVE, "Sales", "AZ", 140000.0));
		
		return employees;
	}

}
