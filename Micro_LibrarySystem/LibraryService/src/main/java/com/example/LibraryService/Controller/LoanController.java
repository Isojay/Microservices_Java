package com.example.LibraryService.Controller;

import com.example.LibraryService.DTO.LoanDTO;
import com.example.LibraryService.DTO.LoanResponse;
import com.example.LibraryService.Entity.Book_Loan;
import com.example.LibraryService.Repo.LogRepo;
import com.example.LibraryService.Service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loan")
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<?> loan(@RequestBody LoanDTO loanDTO){
         boolean bool = loanService.loan(loanDTO);
         if (bool){
             return ResponseEntity.ok("Good to Go");
         }else{
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Copies Not available");
        }
    }

    @GetMapping
    public List<LoanResponse> findALl(){
        return loanService.findALl();
    }

    @PutMapping
    public void returnBook(@RequestParam("id") String id){
        loanService.returnBook(id);
    }

    @GetMapping("/due")
    public List<LoanResponse> dueBooks(){
        return loanService.dueBooks();
    }


}
