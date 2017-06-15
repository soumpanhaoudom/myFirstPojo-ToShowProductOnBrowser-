package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImple implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImple(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<StudentModel> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public StudentModel findOne(int id) {
		return studentRepository.findOne(id);
	}

	@Override
	public boolean save(StudentModel studentModel) {
		return studentRepository.save(studentModel);
	}

	@Override
	public boolean remover(int id) {
		return studentRepository.remover(id);
	}

	@Override
	public boolean update(StudentModel student) {
		return studentRepository.update(student);
	}

}
