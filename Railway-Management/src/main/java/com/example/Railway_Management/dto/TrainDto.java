package com.example.Railway_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainDto {
    private Long t_id;
    private int t_no;
    private String t_name;
    private double t_distance;
    private double t_price;
    private String From_To;
}
