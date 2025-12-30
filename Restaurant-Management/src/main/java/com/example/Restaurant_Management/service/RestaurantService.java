package com.example.Restaurant_Management.service;

import com.example.Restaurant_Management.dto.RestaurantDto;
import com.example.Restaurant_Management.entity.Restaurant;

public interface RestaurantService {
    RestaurantDto createitem(RestaurantDto restaurantDto);
    Restaurant getorder(Long id );
    RestaurantDto updateorder(long id,RestaurantDto restaurantDto);
    Restaurant deleteorder(Long id );
}
