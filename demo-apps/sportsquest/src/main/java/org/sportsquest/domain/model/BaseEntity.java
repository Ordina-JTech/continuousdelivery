package org.sportsquest.domain.model;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.annotation.GraphId;

public abstract class BaseEntity {

	@Autowired
	private Validator validator;
	
	@GraphId Long id;
	@CreatedDate protected Long createdDate;
	
	public Long getCreatedDate() {
		return createdDate;
	}

}
