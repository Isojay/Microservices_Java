package com.example.UserServices.Repo;

import com.example.UserServices.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo  extends JpaRepository<Staff,String> {
}
