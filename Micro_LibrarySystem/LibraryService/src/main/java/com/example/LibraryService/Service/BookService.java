package com.example.LibraryService.Service;


import com.example.LibraryService.DTO.BookDTO;
import com.example.LibraryService.DTO.BookResponse;
import com.example.LibraryService.Entity.Book;
import com.example.LibraryService.Repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    public void addBook(BookDTO bookDTO){
        log.info(bookDTO.getAuthor());
        Book book = Book.builder()
                .bid(RandomService.generateCombo(5))
                .author(bookDTO.getAuthor())
                .title(bookDTO.getTitle())
                .genre(bookDTO.getGenre())
                .available(bookDTO.getAvailable())
                .published(bookDTO.getPublished())
                .build();
        bookRepo.save(book);
    }

    public List<BookResponse> findAll(){

        return bookRepo.findAll()
                .stream()
                .map(book -> BookResponse.builder()
                        .bid(book.getBid())
                        .author(book.getAuthor())
                        .title(book.getTitle())
                        .genre(book.getGenre())
                        .published(book.getPublished())
                        .available(book.getAvailable())
                        .build())
                .toList();
    }

    public Optional<BookResponse> findById(String id){
        return bookRepo.findById(id).map(book -> BookResponse.builder()
                .bid(book.getBid())
                .title(book.getTitle())
                .genre(book.getGenre())
                .published(book.getPublished())
                .available(book.getAvailable())
                .build());
    }
    public Optional<Book> findId(String id){
        return bookRepo.findById(id);
    }

    public void deleteById(String id) {
        bookRepo.deleteById(id);
    }

    public void loanDept(Book copy) {
        bookRepo.save(copy);
    }
}
