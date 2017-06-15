package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentModel;
import com.github.javafaker.Faker;

@Repository
public class StudentRepositoryImple implements StudentRepository {

	private List<StudentModel> studentModel;
	
	public StudentRepositoryImple() {
		studentModel = new ArrayList<>();
		Faker faker = new Faker(Locale.ENGLISH);
		
		for(int i=0; i<20; i++){
			StudentModel studentList = new StudentModel();
			
			studentList.setId(i+1);
			studentList.setTitle(faker.name().fullName());
			studentList.setDescription(faker.address().cityName());
			
			studentModel.add(studentList);
		}
	}
	
	@Override
	public List<StudentModel> findAll() {
		return studentModel;
	}

	@Override
	public StudentModel findOne(int id) {
		for(StudentModel studentList:studentModel){
			if(studentList.getId()==id)
				return studentList;
		}
		return null;
	}

	@Override
	public boolean save(StudentModel studentModel) {
		return this.studentModel.add(studentModel);
	}

	@Override
	public boolean remover(int id) {
		for(StudentModel studentList:studentModel){
			if(studentList.getId()==id){
				studentModel.remove(studentList);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(StudentModel student) {
		for(int i=0; i<studentModel.size();i++){
			if(student.getId()==studentModel.get(i).getId()){
				studentModel.get(i).setId(student.getId());
				studentModel.get(i).setTitle(student.getTitle());
				studentModel.get(i).setDescription(student.getDescription());
				
				return true;
			}
			return false;
		}
		return false;
	}

}
