package com.example.LibraryService.Repo;

import com.example.LibraryService.Entity.Book_Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Book_Loan, String> {
}
