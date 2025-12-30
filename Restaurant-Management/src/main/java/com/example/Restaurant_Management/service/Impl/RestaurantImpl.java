package com.example.Restaurant_Management.service.Impl;

import com.example.Restaurant_Management.dto.RestaurantDto;
import com.example.Restaurant_Management.entity.Restaurant;
import com.example.Restaurant_Management.repository.RestaurantRepository;
import com.example.Restaurant_Management.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    @Override
    public RestaurantDto createitem(RestaurantDto restaurantDto) {
        Restaurant restaurant=new Restaurant(
                restaurantDto.getId(),
                restaurantDto.getName(),
                restaurantDto.getPrice()
        );
        Restaurant saveditem=repository.save(restaurant);
        RestaurantDto saveitem=new RestaurantDto(
                saveditem.getId(),
                saveditem.getName(),
                saveditem.getPrice()
        );
        return saveitem;
    }

    @Override
    public Restaurant getorder(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found with specified id "));
    }

    @Override
    public RestaurantDto updateorder(long id, RestaurantDto restaurantDto) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("order not found with the specified id "));
        restaurant.setName(restaurantDto.getName());
        restaurant.setPrice(restaurantDto.getPrice());
        Restaurant updateditem = repository.save(restaurant);
        return new RestaurantDto(
                updateditem.getId(),
                updateditem.getName(),
                updateditem.getPrice()
        );
    }
    public Restaurant deleteorder(Long id){
        Restaurant restaurant1=repository.findById(id)
                .orElseThrow(()->new RuntimeException("Order not found with id"));
        repository.delete(restaurant1);
return restaurant1;

    }
}
