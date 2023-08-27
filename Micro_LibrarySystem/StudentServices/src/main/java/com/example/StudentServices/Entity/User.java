package com.example.StudentServices.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user")
public class User {

    @Id
    private String id;

    private String username;
    private String password;
    private String fname;
    private String lname;
    private Long contact;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;

}
