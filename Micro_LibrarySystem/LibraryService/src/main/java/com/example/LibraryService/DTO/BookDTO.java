package com.example.LibraryService.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String title;

    private String author;

    private String genre;

    private int published;

    private int available;



}
