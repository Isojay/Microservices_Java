package com.example.LibraryService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private String bid;

    private String title;

    private String author;

    private String genre;

    private String imgName;

    private int published;

    private int available;

}
