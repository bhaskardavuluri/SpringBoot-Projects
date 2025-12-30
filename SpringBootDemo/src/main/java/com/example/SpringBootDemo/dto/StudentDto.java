package com.example.SpringBootDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;

    private String name;

    private double marks;

}