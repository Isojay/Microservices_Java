package com.example.LibraryService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_Loan")
public class Book_Loan {

    @Id
    private String lId;

    @ManyToOne
    @JoinColumn(name = "Book_id")
    private Book book;

    private String studentId;

    private LocalDateTime borrowedDate;

    private LocalDateTime due;

    private LocalDateTime returnDate;

}
