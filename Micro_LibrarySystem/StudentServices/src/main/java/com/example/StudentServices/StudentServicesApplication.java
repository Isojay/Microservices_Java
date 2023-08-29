package com.example.StudentServices;

import com.example.StudentServices.Service.UtilService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}
	@PostConstruct
	public void init(){
		UtilService.createDirectoryIfNeeded();
	}
}
