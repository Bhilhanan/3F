package com.threef.datastore.Entities;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType=IdentityType.APPLICATION,detachable="true")
public class Objects {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;	
	@Persistent
	private String objects;	
	@Persistent
	private MethodRepository methodRepositoryId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObjects() {
		return objects;
	}
	public void setObjects(String objects) {
		this.objects = objects;
	}
	public MethodRepository getMethodRepositoryId() {
		return methodRepositoryId;
	}
	public void setMethodRepositoryId(MethodRepository methodRepositoryId) {
		this.methodRepositoryId = methodRepositoryId;
	}
	
}