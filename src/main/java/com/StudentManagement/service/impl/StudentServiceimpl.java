package com.StudentManagement.service.impl;

import org.springframework.stereotype.Service;

import com.StudentManagement.model.Student;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {
	private StudentRepository studentRepository;

	public StudentServiceimpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Iterable<Student> displayAllStudent() {

		return studentRepository.findAll();
	}

	@Override
	public Student displayById(Long id) {
		/*
		 * if(existsById(id)) { return studentRepository.findById(id).get(); }
		 */
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Long id) {
		Student existingStudent = studentRepository.findById(id).get();
		/*
		existingStudent.setFName(updatedStudent.getFName());
		existingStudent.setLName(updatedStudent.getLName());
		existingStudent.setGender(updatedStudent.getGender());
		existingStudent.setAddress(updatedStudent.getAddress());
		existingStudent.setEmail(updatedStudent.getEmail());
		existingStudent.setMobile(updatedStudent.getMobile());*/
		return existingStudent;
	}

	@Override
	public void deleteStudentbyId(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void deleteStudent() {
		studentRepository.deleteAll();
	}

}
