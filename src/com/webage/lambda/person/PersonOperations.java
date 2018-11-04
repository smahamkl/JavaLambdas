package com.webage.lambda.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonOperations {
	public static String fullAddress(Person p) {
		return p.getAddress() + ", " + p.getCity() + ", " + 
				p.getState() + "  " + p.getZipCode();
	}
	
	public static Person generateNewPerson() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Susan", "Adams", 36, Gender.FEMALE,
				"susan@mycompany.com", "333-111-6767", "109 Marion St.",
				"Seattle", "WA", 98104));
		people.add(new Person("John", "Hall", 25, Gender.MALE,
				"john@mycompany.com", "555-456-1347", "346 E 2nd St.",
				"Los Angeles", "CA", 90012));
		people.add(new Person("Efren", "Jasso", 47, Gender.MALE,
				"efren@mycompany.com", "520-376-7538", "133 W 23rd St.",
				"Tucson", "AZ", 85713));
		int random = new Random().nextInt(3);
		return people.get(random);
	}
}
