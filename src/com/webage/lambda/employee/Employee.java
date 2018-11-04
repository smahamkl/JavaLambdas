package com.webage.lambda.employee;

public class Employee {
	private String firstName;
	private String lastName;
	private Role role;
	private String department;
	private String state;
	private double salary;
	
	public Employee(String firstName, String lastName, Role role, String department, String state, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.department = department;
		this.state = state;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + " Role: " +
				role + " Dept: " + department + " State: " +
				state + " Salary: " + String.format("$%,6.2f", salary);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
