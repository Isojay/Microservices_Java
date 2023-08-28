package com.example.StudentServices.DTO;

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
    private String forUser;
    private String addressCity;
    private String addressCountry;

//    for Student

    private String Faculty;

    private String department;

    private String position;
}
