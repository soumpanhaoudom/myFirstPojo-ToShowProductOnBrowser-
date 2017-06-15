package com.example.demo.service;

import java.util.List;

import com.example.demo.model.StudentModel;

public interface StudentService {

	List<StudentModel> findAll();
	StudentModel findOne(int id);
	boolean save(StudentModel studentModel);
	boolean remover(int id);
	boolean update(StudentModel student);

}
