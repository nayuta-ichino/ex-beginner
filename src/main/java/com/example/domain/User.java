package com.example.domain;

public class User {
	// フィールド変数
	private String name;
	private Integer age;
	private String comment;

	// getter,setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	// toString
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}
}
