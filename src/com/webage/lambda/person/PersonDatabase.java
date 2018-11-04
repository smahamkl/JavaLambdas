package com.webage.lambda.person;

import java.util.ArrayList;
import java.util.List;

public class PersonDatabase {
	public static List<Person> createPersonList() {
		List<Person> people = new ArrayList<>();
		
		people.add(new Person("Bob", "Thompson", 46, Gender.MALE,
				"bob@mycompany.com", "555-123-4567", "100 Broadway",
				"New York", "NY", 10005));
		people.add(new Person("Susan", "Brown", 27, Gender.FEMALE,
				"susan@mycompany.com", "222-444-1267", "141 N Los Angeles St.",
				"Los Angeles", "CA", 90012));
		people.add(new Person("John", "Adams", 24, Gender.MALE,
				"john@mycompany.com", "333-111-6767", "109 Marion St.",
				"Seattle", "WA", 98104));
		people.add(new Person("Jill", "Hall", 17, Gender.FEMALE,
				"jill@mycompany.com", "555-456-1347", "346 E 2nd St.",
				"Los Angeles", "CA", 90012));
		people.add(new Person("Devon", "Jasso", 68, Gender.FEMALE,
				"devon@mycompany.com", "520-376-7538", "133 W 23rd St.",
				"Tucson", "AZ", 85713));
		people.add(new Person("Wally", "Schumaker", 15, Gender.MALE,
				"wally@mycompany.com", "555-275-8435", "100 Broadway",
				"New York", "NY", 10005));
		people.add(new Person("Nicole", "Allen", 53, Gender.FEMALE,
				"nicole@mycompany.com", "450-876-9435", "2300 Steele St",
				"Denver", "CO", 80205));
		
		return people;
	}
}
