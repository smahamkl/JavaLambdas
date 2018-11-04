package com.webage.lambda.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.webage.lambda.employee.Employee;
import com.webage.lambda.employee.EmployeeDatabase;

public class AdvancedFunctionTest {
	private static List<Employee> employees = EmployeeDatabase.createEmployeeList();
	private static BiConsumer<String, String> printStateMap = (k, v) -> System.out
			.println("Key: " + k + " Value: " + v);

	public static void main(String[] args) {

		useRemoveIf(employees);
		useComputeIfAbsent(initializeStateMap());
		useMerge(initializeStateMap());
		useReadAllLines();
		useFlatMap();

	}

	private static Map<String, String> initializeStateMap() {
		Map<String, String> stateMap = new HashMap<>();

		stateMap.put("AZ", "Phoenix");
		stateMap.put("FL", "Tallahassee");
		stateMap.put("MI", "Lansing");
		stateMap.put("MD", "Annapolis");
		stateMap.put("CO", "Denver");
		return stateMap;
	}

	private static void useRemoveIf(List<Employee> employees) {
		System.out.println("--- RemoveIf MO Employees ---");
		ArrayList<Employee> empArr = (ArrayList<Employee>) employees;
		System.out.println("---List before removal-----");

		empArr.forEach(e -> System.out.println(e));

		empArr.removeIf(e -> e.getState().equals("MO"));
		System.out.println("--- List after removal--");
		empArr.forEach(e -> System.out.println(e));

	}

	private static void useComputeIfAbsent(Map<String, String> stateMap) {
		System.out.println("--- ComputeIfAbsent Demo ---");

		stateMap.computeIfAbsent("TN", v -> "Memphis");
		stateMap.computeIfAbsent("IL", v -> "Springfield");

		stateMap.forEach(printStateMap);
	}

	private static void useMerge(Map<String, String> stateMap) {
		System.out.println("--- Merge Demo ---");

		String msg = " (Processed M State)";
		List<String> mList = stateMap.keySet().stream().filter(s -> s.startsWith("M")).collect(Collectors.toList());
		mList.add("MA");
		mList.stream().forEach((e) -> stateMap.merge(e, msg, (s, m) -> s.concat(m)));
		stateMap.forEach(printStateMap);

	}

	private static void useReadAllLines() {
		System.out.println("--- readAllLines Demo ---");

	}

	private static void useFilesList() {
		System.out.println("--- Files.list Demo ---");

	}

	private static void useFilesWalk() {
		System.out.println("--- Files.walk Demo ---");

	}

	private static void useFlatMap() {
		System.out.println("--- flatMap Demo ---");
		Path file = Paths.get("RomeoJuliet.txt");

		try (Stream<String> lines = Files.lines(file)) {
			long matches = lines.flatMap(line -> Stream.of(line.split(" ")))
					.filter(word -> ((String) word).contains("thou"))
					.peek(word -> System.out.println("Matching word: " + word)).count();

		} catch (Exception ex) {

		}

	}

}
