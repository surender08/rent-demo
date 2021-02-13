package com.databasetesting.mydata.services;

import com.databasetesting.mydata.model.Student;

public interface StudentService {
	Student save(Student st);
	Student getStuById(int id);
}
