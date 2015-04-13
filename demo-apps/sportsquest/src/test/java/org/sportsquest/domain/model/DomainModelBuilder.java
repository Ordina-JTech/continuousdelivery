package org.sportsquest.domain.model;

import java.util.ArrayList;

public class DomainModelBuilder {

	public static ArrayList<User> setupUsersSallyAndSusan() {

		User sally = new User("sally@hatseflats.com");
		sally.setUsername("Sally");
		User susan = new User("susan@hatseflats.com");
		susan.setUsername("Susan");

		sally.addPeer(susan);
		
		ArrayList<User> users = new ArrayList<User>();
		users.add(susan);
		users.add(sally);
		return users;
	}
}
