package com.learnmyfirstprg.learncamelsimplefile;

public class Employee {
	private String name;
	private String id;
	private String joinDate;
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", joinDate="
				+ joinDate + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

}
