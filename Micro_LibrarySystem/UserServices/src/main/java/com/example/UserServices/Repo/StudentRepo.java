package com.example.UserServices.Repo;

import com.example.UserServices.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {

    Student findStudentByUser_Id(String id);

}
