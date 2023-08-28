package com.example.StudentServices.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user")
public class User{

    @Id
    private String id;

    private String username;

    private String password;

    @Column(name = "First_Name")
    private String fname;

    @Column(name="Last_Name")
    private String lname;

    @Column(name="Phone_Number")
    private Long contact;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "Created")
    private LocalDateTime created;

    @Column(name = "Last_Updated")
    private LocalDateTime updated;

    private String addressCity;
    private String addressCountry;

    @Column(unique = true)
    @NotEmpty
    private String email;

    private boolean isEnabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Staff staff;
}
