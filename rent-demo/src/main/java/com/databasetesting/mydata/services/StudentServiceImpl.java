package com.databasetesting.mydata.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.databasetesting.mydata.model.Student;
import com.databasetesting.mydata.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studrepository;
	
	@Override
	public Student save(Student stud) {
		// TODO Auto-generated method stub
		return studrepository.save(stud);
	}
	
	@Override
	public Student getStuById(int id) {
		Optional<Student> st = studrepository.findById(id);
		if(st.isPresent()) {
			return st.get();
		}
		return null;
	}
}
