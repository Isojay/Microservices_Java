package com.example.LibraryService.Repo;

import com.example.LibraryService.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,String> {

    Book findAllByGenre(String Genre);

}
