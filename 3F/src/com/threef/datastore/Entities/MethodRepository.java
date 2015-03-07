package com.threef.datastore.Entities;

import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class MethodRepository {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;	
	@Persistent
	private String methodName;
	@Persistent
	private String action;	
	@Persistent(mappedBy="subject")
	private Set<Subject> subjects;
	@Persistent(mappedBy="verb")
	private Set<Verb> verbs;
	@Persistent(mappedBy="objects")
	private Set<Objects> objectss;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public Set<Verb> getVerbs() {
		return verbs;
	}
	public void setVerbs(Set<Verb> verbs) {
		this.verbs = verbs;
	}
	public Set<Objects> getObjectss() {
		return objectss;
	}
	public void setObjectss(Set<Objects> objectss) {
		this.objectss = objectss;
	}
	
}
