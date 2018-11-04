package com.webage.lambda.intro;

import java.util.List;
import java.util.function.Predicate;

//import com.webage.lambda.person.Gender;
import com.webage.lambda.person.Person;
import com.webage.lambda.person.PersonContact;

public class PersonSearch {
	PersonContact contact = new PersonContact();

	public void callMatchingPeople(List<Person> people, Predicate<Person> aTest) {
		for (Person p : people) {
			if (aTest.test(p)) {
				contact.callPerson(p);
			}
		}
	}
	
	public void mailMatchingPeople(List<Person> people, Predicate<Person> aTest) {
		for (Person p : people) {
			if (aTest.test(p)) {
				contact.mailPerson(p);
			}
		}
	}
	public void emailMatchingPeople(List<Person> people, Predicate<Person> aTest) {
		for (Person p : people) {
			if (aTest.test(p)) {
				contact.emailPerson(p);
			}
		}
	}

//	public void callVoters(List<Person> people) {
//		for (Person p : people) {
//			if (isVoter(p)) {
//				contact.callPerson(p);
//			}
//		}
//	}
//
//	public void mailNewYorkCity(List<Person> people) {
//		for (Person p : people) {
//			if (isNewYork(p)) {
//				contact.mailPerson(p);
//			}
//		}
//	}
//
//	public void emailDraftees(List<Person> people) {
//		for (Person p : people) {
//			if (isDraftee(p)) {
//				contact.emailPerson(p);
//			}
//		}
//	}

//	private boolean isVoter(Person p) {
//		return p.getAge() >= 18;
//	}
//
//	private boolean isNewYork(Person p) {
//		return p.getCity().equalsIgnoreCase("New York");
//	}
//
//	private boolean isDraftee(Person p) {
//		return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
//	}

}
