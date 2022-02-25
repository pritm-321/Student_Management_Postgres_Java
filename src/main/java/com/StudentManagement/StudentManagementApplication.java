package com.StudentManagement;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StudentManagementApplication.class, args);
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(StudentManagementApplication.class);
		builder.headless(false).run(args);
	}

}
