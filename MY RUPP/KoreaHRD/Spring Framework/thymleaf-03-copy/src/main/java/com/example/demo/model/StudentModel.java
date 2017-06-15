package com.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentModel {
	
	@NotNull
	private int id;
	
	@NotNull
	@Size(min =3, max = 30)
	private String title;
	
	@Size(min = 15, max = 1000)
	private String description;

	public StudentModel() {
		super();
	}

	public StudentModel(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
