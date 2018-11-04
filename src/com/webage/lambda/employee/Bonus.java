package com.webage.lambda.employee;

public enum Bonus {
	STAFF(0.03),
	MANAGER(0.07),
	EXECUTIVE(0.1);
	
	Bonus(double bonus) {
		this.bonus = bonus;
	}
	
	private final double bonus;
	
	public static double byRole(Role role) {
		for (Bonus b : Bonus.values()) {
			if (b.toString().equals(role.toString())) {
				return b.bonus;
			}
		}
		return 0.0;
	}
}
