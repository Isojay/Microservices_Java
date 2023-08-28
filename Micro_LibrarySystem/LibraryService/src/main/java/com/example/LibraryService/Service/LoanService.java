package com.example.LibraryService.Service;

import com.example.LibraryService.DTO.LoanDTO;
import com.example.LibraryService.DTO.LoanResponse;
import com.example.LibraryService.Entity.Book;
import com.example.LibraryService.Entity.Book_Loan;
import com.example.LibraryService.Entity.LoanLog;
import com.example.LibraryService.Repo.LoanRepo;
import com.example.LibraryService.Repo.LogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepo loanRepo;
    private final BookService bookService;
    private final LogRepo logRepo;

    public boolean loan(LoanDTO loanDTO){
        Book book = bookService.findId(loanDTO.getBookId()).get();
        int copy = book.getAvailable();
        if (copy == 0 ){
            return false;
        }
        book.setAvailable( book.getAvailable() - 1);
        bookService.loanDept(book);
        Book_Loan loan = Book_Loan.builder()
                .lId(UtilService.generateCombo(5))
                .studentId(loanDTO.getStudentId())
                .book(bookService.findId(loanDTO.getBookId()).get())
                .borrowedDate(LocalDateTime.now())
                .due(LocalDateTime.now().plusDays(10))
                .build();
        loanRepo.save(loan);
        return true;
    }
    public void returnBook(String id){
        Optional<Book_Loan> loan = loanRepo.findById(id);
        if (loan.isPresent()){
            Book_Loan loan1 = loan.get();
            Book book = bookService.findId(loan1.getBook().getBid()).get();
            book.setAvailable( book.getAvailable()+1);
            bookService.loanDept(book);
            loan1.setReturnDate(LocalDateTime.now());
            loanRepo.save(loan1);
            storeLog(loan1);
            loanRepo.deleteById(id);
            log.info("Book Loan Deleted");
        }
    }

    public List<LoanResponse> findALl(){
        return loanRepo.findAll().stream()
                .map(loan ->
                        LoanResponse.builder()
                                .lId(loan.getLId())
                                .bookId(loan.getBook().getBid())
                                .borrowedDate(loan.getBorrowedDate())
                                .due(loan.getDue())
                                .studentId(loan.getStudentId()).build()).toList();

    }

    public void storeLog(Book_Loan loan1){
        LoanLog log1 =LoanLog.builder()
                .lId(loan1.getLId())
                .bookID(loan1.getBook().getBid())
                .borrowedDate(loan1.getBorrowedDate())
                .due(loan1.getDue())
                .returnDate(loan1.getReturnDate())
                .studentId(loan1.getStudentId())
                .build();
        logRepo.save(log1);
        log.info("Log Saved");
    }

    public List<LoanResponse> dueBooks() {
        LocalDateTime time = LocalDateTime.now();
        log.info(String.valueOf(time));
        return loanRepo.findAll().stream()
                .filter(loan1 -> time.isAfter(loan1.getDue()))
                .map(loan1 ->
                        LoanResponse.builder()
                                .lId(loan1.getLId())
                                .bookId(loan1.getBook().getBid())
                                .borrowedDate(loan1.getBorrowedDate())
                                .due(loan1.getDue())
                                .studentId(loan1.getStudentId()).build()).toList();
    }

}
