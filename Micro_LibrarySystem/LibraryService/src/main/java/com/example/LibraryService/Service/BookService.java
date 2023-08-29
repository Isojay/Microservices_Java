package com.example.LibraryService.Service;


import com.example.LibraryService.DTO.BookDTO;
import com.example.LibraryService.DTO.BookResponse;
import com.example.LibraryService.Entity.Book;
import com.example.LibraryService.Repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    public static String Uploaddir = "/home/blue/LBMS/Books";

    public void addBook(BookDTO bookDTO){
        log.info(bookDTO.getAuthor());
        Book book = Book.builder()
                .bid(UtilService.generateCombo(5))
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
                .map(this::mapToBookResponse)
                .toList();
    }

    public Optional<BookResponse> findById(String id){
        return bookRepo.findById(id).map(this::mapToBookResponse);
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

    public String addImg(MultipartFile file, String id) {

        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent()){
            Book book1 = book.get();
            if (file.isEmpty()) {
                return "Empty";
            }
            String originalName = file.getOriginalFilename();
            assert originalName != null;
            String fileExtension = originalName.substring(originalName.lastIndexOf('.'));
            String newName = id + fileExtension;
            book1.setImgName(newName);
            bookRepo.save(book1);
            try {
                File destFile = new File(Uploaddir + File.separator + newName);
                file.transferTo(destFile);

               return ("Success");
            } catch (IOException e) {
                return ("Error uploading image: " + e.getMessage());
            }
        }
        return "Empty Id";
    }

    public void editBook(BookDTO bookDTO) {

        Book book = bookRepo.findById(bookDTO.getId()).get();
        Book book1 = Book.builder()
                .bid(book.getBid())
                .author(bookDTO.getAuthor())
                .title(bookDTO.getTitle())
                .genre(bookDTO.getGenre())
                .available(bookDTO.getAvailable())
                .published(bookDTO.getPublished())
                .build();
        bookRepo.save(book1);

    }

    public BookResponse mapToBookResponse(Book book){
        return BookResponse.builder()
                .bid(book.getBid())
                .author(book.getAuthor())
                .title(book.getTitle())
                .genre(book.getGenre())
                .published(book.getPublished())
                .available(book.getAvailable())
                .imgName(book.getImgName())
                .build();

    }
}
