package com.StudentManagement.controller;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentManagement.exception.InvalidIdException;
import com.StudentManagement.model.Student;
import com.StudentManagement.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	//INSERT
	@GetMapping("/saveStudentLayer")
	public String saveStudentLayer(Student student) {
		return "saveStudentLayer";
	}

	@PostMapping("/saveStudent")
	public String create(@ModelAttribute("student") Student s) {
		studentService.saveStudent(s);
		return "redirect:/";
	}
	//DISPLAY
	@GetMapping("/getAllStudents")
	public String getAllStudents(Model m) {
		m.addAttribute("students", studentService.displayAllStudent());
		return "getStudents";
	}
	
	@GetMapping("/getStudentbyIDLayer")
	public String getStudentbyIDLayer() {
		return "getStudentbyIDLayer";
	}
	
	@PostMapping("/getStudentbyID")
	public String getStudentbyID(@RequestParam("id") Long id,Model m){
		try {
			m.addAttribute("students", studentService.displayById(id));
			return "getStudents";
		} catch (InvalidIdException e) {
			JOptionPane.showMessageDialog(null,e+"\n Please Enter It Again");
			return "getStudentbyIDLayer";
		}
	}
	//update
	@GetMapping("/updateStudentByIDLayer")
	public String updateStudentByIDLayer() {
		return "updateStudentByIDLayer";
	}

	@PostMapping("/updateStudentByID")
	public String updateStudentByID(@RequestParam("id") Long id, Model m) {
		try {
			m.addAttribute("student", studentService.updateStudent(id));
			return "updateStudentForm";
		} catch (InvalidIdException e) {
			JOptionPane.showMessageDialog(null,e+"\n Please Enter It Again");
			return "updateStudentByIDLayer";
		}
	}
	
	//delete
	@GetMapping("/deleteAllStudent")
	public String delete() {
		studentService.deleteStudent();
		return "redirect:/";
	}
	
	@GetMapping("/deleteStudentByIDLayer")
	public String deleteStudentByIDLayer() {
		return "deleteStudentByIDLayer";
	}
	
	@PostMapping("/deleteStudentByID")
	public String deleteStudentByID(@RequestParam("id") Long id) {
		
		try {
			studentService.deleteStudentbyId(id);
			JOptionPane.showMessageDialog(null, "Student Deleted Successfully");
			return "redirect:/";
		} catch (InvalidIdException e) {
			JOptionPane.showMessageDialog(null,e+"\n Please Enter It Again");
			return "deleteStudentByIDLayer";
		}
		
	}
	
	
}
