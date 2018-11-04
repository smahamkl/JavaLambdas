package com.webage.lambda.stream;

import java.util.List;
import java.util.function.Predicate;

import com.webage.lambda.person.Gender;
import com.webage.lambda.person.Person;
import com.webage.lambda.person.PersonContact;
import com.webage.lambda.person.PersonDatabase;

public class StreamTest {

	public static void main(String[] args) {
		List<Person> people = PersonDatabase.createPersonList();
//		// people.forEach(p -> System.out.println(p));
//		people.forEach(System.out::println);
//		PersonContact contact = new PersonContact();
//		System.out.println("-------Calling voters---------");
//		Predicate<Person> voter = p -> p.getAge() >= 18;
//		people.stream().filter(voter).forEach(contact::callPerson);
//		System.out.println("-------Mailing Draftees---------");
//		people.stream().filter(p -> p.getAge() >= 18).filter(p -> p.getAge() <= 25)
//				.filter(p -> p.getGender() == Gender.MALE).forEach(contact::mailPerson);
//
//		System.out.println("-------Calling NewYork Voters---------");
//		Predicate<Person> nyResident = p -> p.getCity().equalsIgnoreCase("New York");
//		people.stream().filter(voter).filter(nyResident).forEach(contact::callPerson);
		
		
		people.forEach(p->System.out.println(p.getFirstName()));
		// -----------------------------------------------------------

		// System.out.println("-------Mailing New York---------");

		// people.stream().filter(nyResident).forEach(contact::mailPerson);
		// System.out.println("-------EMailing Draftees---------");
		// Predicate<Person> draftee = p -> p.getAge() >= 18 && p.getAge() <= 25
		// && p.getGender() == Gender.MALE;
		// people.stream().filter(draftee).forEach(contact::emailPerson);
	}

}
