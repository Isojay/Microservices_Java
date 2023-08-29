package com.example.StudentServices.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "Image_Name")
    private String imgName;

    @Column(name = "City")
    private String addressCity;

    @Column(name = "Country")
    private String addressCountry;

    @Column(unique = true)
    @NotEmpty
    private String email;

    private boolean isEnabled;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Staff staff;
}
