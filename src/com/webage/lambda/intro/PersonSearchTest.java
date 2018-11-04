package com.webage.lambda.intro;

import java.util.List;
import java.util.function.Predicate;

import com.webage.lambda.person.Gender;
import com.webage.lambda.person.Person;
import com.webage.lambda.person.PersonDatabase;

public class PersonSearchTest {

	public static void main(String[] args) {
		List<Person> people = PersonDatabase.createPersonList();

		PersonSearch search = new PersonSearch();

		System.out.println("Lambda expressions - calling voters");
		Predicate<Person> voters = p -> p.getAge() >= 18;
		search.callMatchingPeople(people, voters);
		System.out.println("Lambda expressions - mailing NewYork residents");
		Predicate<Person> newYorkResidents = p -> p.getCity().equalsIgnoreCase("New York");
		search.mailMatchingPeople(people, newYorkResidents);
		System.out.println("Lambda expressions - emailing draftees");
		Predicate<Person> draftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
		search.emailMatchingPeople(people, draftees);
		System.out.println("Lambda expressions - calling retirees");
		Predicate<Person> retirees = p -> p.getAge() >= 65;
		search.callMatchingPeople(people, retirees);

		System.out.println("------- Using predicates - Non Lambda expressions ------");

		search.callMatchingPeople(people, new Predicate<Person>() {
			@Override
			public boolean test(Person p) {
				return p.getAge() >= 18;
			}
		});

		search.mailMatchingPeople(people, new Predicate<Person>() {
			@Override
			public boolean test(Person p) {
				return p.getCity().equalsIgnoreCase("New York");
			}
		});

		search.emailMatchingPeople(people, new Predicate<Person>() {
			@Override
			public boolean test(Person p) {
				return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
			}
		});

		// System.out.println("------- Calling Voters -------");
		// search.callVoters(people);
		//
		// System.out.println("------- Mailing New York -------");
		// search.mailNewYorkCity(people);
		//
		// System.out.println("------- Emailing Draftees -------");
		// search.emailDraftees(people);
	}

}
