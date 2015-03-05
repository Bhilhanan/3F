package com.threef.datastore.Entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION,detachable="true")
public class Annotation {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String annotation;
	
	@Persistent
	private ActionsRepository actionRepository;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public ActionsRepository getActionRepository() {
		return actionRepository;
	}

	public void setActionRepository(ActionsRepository actionRepository) {
		this.actionRepository = actionRepository;
	}
	
	
}
