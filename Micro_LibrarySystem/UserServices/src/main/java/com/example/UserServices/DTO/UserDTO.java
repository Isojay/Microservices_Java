package com.example.UserServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private Long contact;
    private String role;
    private String email;
    private boolean isEnabled;
    private String forUser;
    private String addressCity;
    private String addressCountry;

//    for Student

    private String Faculty;

    private String department;

    private String position;


}
