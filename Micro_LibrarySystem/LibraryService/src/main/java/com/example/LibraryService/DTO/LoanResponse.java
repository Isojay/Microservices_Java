package com.example.LibraryService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoanResponse {

    private String lId;

    private String bookId;

    private String studentId;

    private LocalDateTime borrowedDate;

    private LocalDateTime due;

}
