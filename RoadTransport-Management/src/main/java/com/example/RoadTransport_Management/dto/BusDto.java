package com.example.RoadTransport_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private Long id;
    private String place;
    private String type;
    private double price;
    private double distance;
}
