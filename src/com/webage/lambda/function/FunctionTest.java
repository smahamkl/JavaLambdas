package com.webage.lambda.function;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToLongBiFunction;

import com.webage.lambda.person.Person;
import com.webage.lambda.person.PersonDatabase;
import com.webage.lambda.person.PersonOperations;

public class FunctionTest {

	public static void main(String[] args) {
		List<Person> people = PersonDatabase.createPersonList();
		Predicate<Person> CAPeople = p -> p.getState().equals("CA");
		// people.stream().filter(CAPeople).forEach(p ->
		// System.out.println("Stream person:" + p.getFirstName()));
		// for (Person p : people) {
		// if (CAPeople.test(p)) {
		// System.out.println("Loop Person :" + p.getFirstName());
		// }
		// }
		Consumer<Person> outputPerson = p -> System.out
				.println("Person:" + p.getFirstName() + " " + p.getLastName() + " - " + p.getEmail());
		useConsumer(people, CAPeople, outputPerson);

		Function<Person, String> fullAddress = PersonOperations::fullAddress;
		useFunction(people, outputPerson, fullAddress);

		useSupplier(outputPerson);
		useBiPredicate(people, outputPerson, fullAddress);

		useBiFunction(people);

	}

	private static void useConsumer(List<Person> people, Predicate<Person> predicate, Consumer<Person> outputPerson) {

		System.out.println("------- CA People - Stream -------");
		people.stream().filter(predicate).forEach(outputPerson);

		System.out.println("------- CA People - Method -------");
		for (Person p : people) {
			if (predicate.test(p))
				outputPerson.accept(p);
		}

	}

	private static void useFunction(List<Person> people, Consumer<Person> outputPerson,
			Function<Person, String> fullAddress) {
		System.out.println("------- Function Demo -------");
		for (Person p : people) {
			outputPerson.accept(p);
			System.out.print(fullAddress.apply(p));
		}

	}

	private static void useSupplier(Consumer<Person> outputPerson) {
		System.out.println("------- Supplier Demo -------");
		Supplier<Person> generator = PersonOperations::generateNewPerson;
		Person newPerson = generator.get();
		outputPerson.accept(newPerson);
	}

	private static void useBiPredicate(List<Person> people, Consumer<Person> outputPerson,
			Function<Person, String> fullAddress) {
		System.out.println("------- BiPredicate Demo - NY People -------");
		BiPredicate<Person, String> sbp = (p, s) -> p.getState().equals(s);
		for (Person p : people) {
			if (sbp.test(p, "NY")) {
				outputPerson.accept(p);
				System.out.println(fullAddress.apply(p));
			}
		}
	}

	private static void useBiFunction(List<Person> people) {
		System.out.println("------- ToLongBiFunction Demo -------");
		ToLongBiFunction<List<Person>, String> countInState = (t, s) -> t.stream().filter(p -> p.getState().equals(s))
				.count();
		System.out.println("there are " + countInState.applyAsLong(people, "CA") + " people in CA");
	}

}
