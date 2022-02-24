package com.StudentManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentmanagement")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	@Column(name = "fname")
	private String fName;
	@Column(name = "lname")
	private String lName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "address")
	private String address;
	@Column(name = "mobile")
	private Long mobile;
	@Column(name = "email")
	private String email;
}
