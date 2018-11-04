package com.webage.lambda.operations;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.webage.lambda.employee.Bonus;
import com.webage.lambda.employee.Employee;
import com.webage.lambda.employee.EmployeeDatabase;
import com.webage.lambda.employee.Role;

public class OperationsTest {
	private static Consumer<Employee> outputName = e -> System.out
			.print("Name: " + e.getFirstName() + " " + e.getLastName());
	private static Consumer<Double> printFormatBonus = s -> System.out.printf("  Bonus: $%,6.2f %n", s);
	private static Function<Employee, Double> bonusCalc = e -> e.getSalary() * Bonus.byRole(e.getRole());

	public static void main(String[] args) {
		List<Employee> employees = EmployeeDatabase.createEmployeeList();
		useMapPeek(employees);

		useFindFirst(employees);

		useCount(employees);

		useSum(employees);

		useMin(employees);

	}

	private static void useMapPeek(List<Employee> employees) {
		System.out.println("--- Map & Peek - CT Bonuses ---");
		employees.stream().filter(e -> e.getState().equals("CT")).peek(outputName).map(bonusCalc)
				.forEach(printFormatBonus);
	}

	private static void useFindFirst(List<Employee> employees) {
		System.out.println("--- findFirst - CT Bonuses ----");

		System.out.println("--- forEach ---");

		employees.stream().peek(e -> System.out.println("Processing element")).filter(e -> e.getState().equals("CT"))
				.peek(e -> System.out.println("CT Employee")).map(bonusCalc).forEach(printFormatBonus);

		System.out.println("--- findFirst ---");

		Optional<Employee> result = employees.stream().peek(e -> System.out.println("Processing element"))
				.filter(e -> e.getState().equals("CT")).peek(e -> System.out.println("CT Employee")).findFirst();
		if (result.isPresent()) {
			System.out.println(result.get());
		}
	}

	private static void useCount(List<Employee> employees) {
		System.out.println("--- Manager count ---");
		long managerCnt = employees.stream().filter(e -> e.getRole().equals(Role.MANAGER)).count();

		System.out.println("Manager count:" + managerCnt);

	}

	private static void useSum(List<Employee> employees) {
		System.out.println("--- Sum of all salary from AZ ---");
		double result = employees.stream().filter(e -> e.getState().equals("AZ")).peek(outputName)
				.mapToDouble(e -> e.getSalary()).peek(d -> System.out.printf("  Salary: $%,6.2f %n", d)).sum();

	}

	private static void useMin(List<Employee> employees) {
		System.out.println("--- Find lowest paid staff ---");
		Optional<Employee> lowestPaid = employees.stream().filter(e -> e.getRole().equals(Role.STAFF))
				.min(Comparator.comparingDouble(e -> e.getSalary()));
		if (lowestPaid.isPresent()) {
			System.out.println("Lowest paid employee:" + lowestPaid.get());
		}

	}

	private static void useSort(List<Employee> employees) {
		System.out.println("--- Sorted Executive bonuses ---");

	}

	private static void useCollect(List<Employee> employees) {
		System.out.println("--- Collect Managers sorted by Last Name ---");

	}

	private static void useCollectGrouping(List<Employee> employees) {
		System.out.println("--- Group Employees by department ---");

	}

	private static void useCollectPartition(List<Employee> employees) {
		System.out.println("--- Partition by Executives ---");

	}

}
