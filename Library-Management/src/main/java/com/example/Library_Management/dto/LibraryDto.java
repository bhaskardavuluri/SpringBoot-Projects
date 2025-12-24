package com.example.Library_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LibraryDto {
    private Long id;
    private String name;
    private String author;
    private int price;

}
