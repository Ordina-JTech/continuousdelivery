package org.sportsquest.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sportsquest.domain.model.User;
import org.sportsquest.domain.repositories.UserRepository;

@Component
public class UserAdministrationService {
	
	@Autowired
	UserRepository userRepo;
	
	public void verifyAndsetUserName(final User user, final String username){
		
		if (null == userRepo.findByUsername(username)) {
			user.setUsername(username);
			userRepo.save(user);
		} else {
			throw new IllegalArgumentException("Username ["+ username +"] already taken, please try anotherone." );
		}
	}
}
