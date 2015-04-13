package org.sportsquest.domain.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.sportsquest.domain.model.User;

public interface UserRepository extends GraphRepository<User> {

	User findByUsername(String userName);

	User findByEmailaddress(String emailAddress);
	
}
