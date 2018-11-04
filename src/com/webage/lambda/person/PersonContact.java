package com.webage.lambda.person;

public class PersonContact {
	public void emailPerson(Person p) {
		System.out.println("Emailing " + p.getFirstName() + " " +
				p.getLastName() + " age " + p.getAge() +
				" at " + p.getEmail());
	}

	public void callPerson(Person p) {
		System.out.println("Calling " + p.getFirstName() + " " +
				p.getLastName() + " age " + p.getAge() +
				" at " + p.getPhone());
	}

	public void mailPerson(Person p) {
		System.out.println("Mailing " + p.getFirstName() + " " +
				p.getLastName() + " age " + p.getAge() +
				" at " + p.getAddress() + ", " + p.getCity() +
				", " + p.getState() + " " + p.getZipCode());
	}
}
