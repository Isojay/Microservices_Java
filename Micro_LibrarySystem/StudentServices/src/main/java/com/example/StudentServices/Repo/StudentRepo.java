package com.example.StudentServices.Repo;

import com.example.StudentServices.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {

}
