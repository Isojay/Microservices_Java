package com.example.LibraryService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book {

    @Id
    private String bid;

    private String title;

    private String author;
    private String imgName;

    private String genre;

    private int published;

    private int available;

}


















