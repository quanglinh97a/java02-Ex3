package com.quanglinhit.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private long id;
	private String name;
	private String email;
	private String rollNumber;
	private String className;
	private int status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Student(long id, String name, String email, String rollNumber, String className, int status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rollNumber = rollNumber;
		this.className = className;
		this.status = status;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return id + " ; " + name + " ; " + email + " ; " + rollNumber
				+ " ; " + className + " ; " + status;
	}
	
}
