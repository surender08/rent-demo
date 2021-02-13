package com.databasetesting.mydata.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.databasetesting.mydata.model.Student;
import com.databasetesting.mydata.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Student", description = "An entity to represent the person or application")
@RestController
public class MainConroller {
	
	@Operation(summary = "Hello world from GET", description = "Hello world from GET")
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String greetings() {
		return "hello world from GET";
	}
	
	@Autowired
	StudentService stserv;
	
	@Operation(summary = "Save Student", description = "Save student entity in the database")
	@RequestMapping(value= "/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student st) {
		return stserv.save(st);
	}
	
	@Operation(summary = "Get a Student using Id", description = "Get the student with given id from the database")
	@RequestMapping(value= "/student", method = RequestMethod.GET)
	public ResponseEntity<Student> fetchStuById(@RequestParam int id) {
		Student stt = stserv.getStuById(id);
		if(stt == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(stt);
		}
		
	}
}
