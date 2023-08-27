package com.example.StudentServices.Repo;

import com.example.StudentServices.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo  extends JpaRepository<Staff,String> {
}
