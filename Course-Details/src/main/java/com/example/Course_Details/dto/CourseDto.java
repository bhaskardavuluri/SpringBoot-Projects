package com.example.Course_Details.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDto {
    private Long id;
    private String cname;
    private int fees;
}
