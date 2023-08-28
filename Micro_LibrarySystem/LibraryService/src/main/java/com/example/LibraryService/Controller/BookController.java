package com.example.LibraryService.Controller;

import com.example.LibraryService.DTO.BookDTO;
import com.example.LibraryService.DTO.BookResponse;
import com.example.LibraryService.DTO.MsgReponse;
import com.example.LibraryService.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;
    MsgReponse msgReponse = new MsgReponse();

    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
    }

    @PutMapping
    public void editBook() {

    }


    @PostMapping("/upByImg")
    public ResponseEntity<?> upByimg(@RequestParam("file") MultipartFile file,
                                     @RequestParam("id") String id) throws IOException {

        String msg = bookService.addImg(file,id);
        if (Objects.equals(msg, "Success")){
            msgReponse.setMessage("Image uploaded successfully");
            return ResponseEntity.ok(msgReponse);
        }else{
            ResponseEntity.status(500).body(msg);
        }
        return null;

    }
}