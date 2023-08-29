package com.example.StudentServices.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Staff")
public class Staff {

    @Id
    private String id;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;

    private String department;

    private String position;
}
