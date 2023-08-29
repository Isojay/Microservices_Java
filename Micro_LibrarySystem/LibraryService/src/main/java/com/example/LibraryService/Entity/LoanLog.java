package com.example.LibraryService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan_Log")
public class LoanLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lId;

    private String bookID;

    private String studentId;

    private LocalDateTime borrowedDate;

    private LocalDateTime due;

    private LocalDateTime returnDate;

}
