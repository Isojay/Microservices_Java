package com.example.StudentServices.Repo;

import com.example.StudentServices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
