package com.example.StudentServices.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {

    @Id
    private String sid;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="Enrollment_Yeat")
    private Year enroll;

    private String Faculty;


}
