package com.example.LibraryService.Controller;

import com.example.LibraryService.DTO.BookDTO;
import com.example.LibraryService.DTO.BookResponse;
import com.example.LibraryService.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO){
        bookService.addBook(bookDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteById(id);
    }

    @PutMapping
    public void editBook(){

    }

}
