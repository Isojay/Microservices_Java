package com.example.UserServices.DTO;

import com.example.UserServices.Entity.Staff;
import com.example.UserServices.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
