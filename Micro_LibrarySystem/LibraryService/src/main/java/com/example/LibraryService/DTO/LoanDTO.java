package com.example.LibraryService.DTO;

import com.example.LibraryService.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private String bookId;

    private String studentId;



}
