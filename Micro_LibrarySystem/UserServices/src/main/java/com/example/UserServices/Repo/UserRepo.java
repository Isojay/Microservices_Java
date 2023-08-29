package com.example.UserServices.Repo;

import com.example.UserServices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
