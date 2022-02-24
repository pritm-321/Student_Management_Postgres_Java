package com.StudentManagement.service;

import com.StudentManagement.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);//insert

	Iterable<Student> displayAllStudent();//displayAll
	
	Student displayById(Long id);//displaybyId
	
	Student updateStudent(Long id); // update by ID
	
	void deleteStudentbyId(Long id);// deletebyId
	
	void deleteStudent();//deleteAll
}
