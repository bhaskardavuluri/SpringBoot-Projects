package com.example.Restaurant_Management.controller;

import com.example.Restaurant_Management.dto.RestaurantDto;
import com.example.Restaurant_Management.entity.Restaurant;
import com.example.Restaurant_Management.service.Impl.RestaurantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RestaurantController {
    @Autowired
    private RestaurantImpl service;
    @PostMapping("/saveRest")
    public ResponseEntity<RestaurantDto>createitems(@RequestBody RestaurantDto restaurantDto){
        RestaurantDto s=service.createitem(restaurantDto);
        return new ResponseEntity<>(s, HttpStatus.CREATED);

    }
    @GetMapping ("/{id}")
    public ResponseEntity<Restaurant>getitems(@PathVariable Long id ){
        Restaurant r=service.getorder(id);
        return new ResponseEntity<>(r,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto>updateitemlist(@PathVariable Long id ,@RequestBody RestaurantDto restaurantDto){
        RestaurantDto r=service.updateorder(id,restaurantDto);
        return new ResponseEntity<>(r,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String>deleteitems(@PathVariable Long id){
        service.deleteorder(id);
        return ResponseEntity.ok("items deleted succesfully");
    }
}
