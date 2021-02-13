package com.databasetesting.mydata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import com.databasetesting.mydata.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	//Student save(Student st);
}
