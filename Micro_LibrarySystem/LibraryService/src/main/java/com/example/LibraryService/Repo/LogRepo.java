package com.example.LibraryService.Repo;

import com.example.LibraryService.Entity.LoanLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<LoanLog, Integer> {
}
