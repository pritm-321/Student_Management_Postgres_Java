package com.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
