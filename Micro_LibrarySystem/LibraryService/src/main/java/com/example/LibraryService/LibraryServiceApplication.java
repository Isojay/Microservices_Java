package com.example.LibraryService;

import com.example.LibraryService.Service.UtilService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	@PostConstruct
	public void init(){
		UtilService.createDirectoryIfNeeded();
	}

}
