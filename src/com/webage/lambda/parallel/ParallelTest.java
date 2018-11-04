package com.webage.lambda.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.webage.lambda.employee.Employee;
import com.webage.lambda.employee.EmployeeDatabase;
import com.webage.lambda.employee.Role;

public class ParallelTest {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeDatabase.createEmployeeList();

		convertOldStyle(employees);

		avoidStateful(employees);

		nonDeterministic(employees);

		demoReduction();
	}

	private static void convertOldStyle(List<Employee> employees) {
		System.out.println("--- Convert from old style processing ---");

		double sum = 0;

		/*
		 * for (Employee e : employees) { if(e.getState().equals("CT") &&
		 * e.getRole().equals(Role.EXECUTIVE)) { System.out.println(e); sum +=
		 * e.getSalary(); } }
		 */

		sum = employees.stream().filter(e -> e.getState().equals("CT")).filter(e -> e.getRole().equals(Role.EXECUTIVE))
				.peek(e -> System.out.println(e)).parallel().mapToDouble(e -> e.getSalary()).sum();

		System.out.printf("Total CT Executive Pay: $%,8.2f %n", sum);
	}

	private static void avoidStateful(List<Employee> employees) {
		System.out.println("--- Convert bad implementation ---");

		List<Employee> newList1 = new ArrayList<>();
		List<Employee> newList2 = new ArrayList<>();

		System.out.println("--- List 1 ---");
		employees.stream().filter(e -> e.getDepartment().equals("Sales")).forEach(e -> newList1.add(e));

		newList1.forEach(e -> System.out.println(e));

		System.out.println("--- List 2 ---");
		newList2 = employees.stream().filter(e -> e.getDepartment().equals("Sales")).collect(Collectors.toList());

		newList2.forEach(e -> System.out.println(e));
	}

	private static void nonDeterministic(List<Employee> employees) {
		System.out.println("--- Non-Deterministic operation ---");

		Optional<Employee> e1 = employees.stream().filter(e -> e.getRole().equals(Role.MANAGER)).sequential().findAny();
		Optional<Employee> e2 = employees.stream().filter(e -> e.getRole().equals(Role.MANAGER)).parallel().findAny();

		System.out.println("The same? " + e1.get().getLastName().equals(e2.get().getLastName()));

	}

	private static void demoReduction() {
		System.out.println("--- Reduction Demo ---");
		int r1 = IntStream.rangeClosed(1, 10).reduce(0, (result, element) -> result + element);
		int r2 = IntStream.rangeClosed(1, 10).parallel().reduce(0, (result, element) -> result + element);
		System.out.println("Result # 1 " + r1);
		System.out.println("Parallel result: " + r2);
	}

}
