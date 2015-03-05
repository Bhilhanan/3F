package com.threef.datastore.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.threef.datastore.actions.Action;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class ActionsRepository {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String methodName;
	@Persistent
	private Action action;
	
	@Persistent(mappedBy="actionRepository")
	@Element(dependent="true")
	private List<Annotation> annotationList=new ArrayList<Annotation>();

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

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public List<Annotation> getAnnotationList() {
		return annotationList;
	}

	public void setAnnotationList(List<Annotation> annotationList) {
		this.annotationList = annotationList;
	}
	
	
}
