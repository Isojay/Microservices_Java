package com.example.UserServices;

import com.example.UserServices.Service.UtilService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServicesApplication.class, args);
	}
	@PostConstruct
	public void init(){
		UtilService.createDirectoryIfNeeded();
	}
}
