package com.StudentManagement.service.impl;

import org.springframework.stereotype.Service;

import com.StudentManagement.exception.InvalidIdException;
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
		
		if (studentRepository.findById(id).isPresent()) {
			return studentRepository.findById(id).get();
		} else {
			throw new InvalidIdException("Student", "Id", id);
		}
		
		/*return studentRepository.findById(id).get().orElseThrow(() -> 
		new ResourceNotFoundException("Student","Id", id));*/
	}

	@Override
	public Student updateStudent(Long id) {
		if (studentRepository.findById(id).isPresent()) {
			return studentRepository.findById(id).get();
		} else {
			throw new InvalidIdException("Student", "Id", id);
		}
	}

	@Override
	public void deleteStudentbyId(Long id) {
		if (studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
		}
		else {
			throw new InvalidIdException("Student", "Id", id);
		}
	}

	@Override
	public void deleteStudent() {
		studentRepository.deleteAll();
	}

}
