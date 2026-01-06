package com.example.Zepto_Mangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id ;
    private  String name;
    private double discount;
    private  double price;
}
