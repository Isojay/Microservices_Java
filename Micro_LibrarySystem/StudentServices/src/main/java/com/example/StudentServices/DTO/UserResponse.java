package com.example.StudentServices.DTO;

import com.example.StudentServices.Entity.Staff;
import com.example.StudentServices.Entity.Student;
import com.example.StudentServices.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String id;
    private String username;
    private String fname;
    private String lname;
    private Long contact;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean isEnabled;
    private String addressCity;
    private String addressCountry;
    private String imgName;
    private Student student;
    private Staff staff;

}
