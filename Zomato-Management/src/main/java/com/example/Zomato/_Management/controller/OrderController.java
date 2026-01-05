package com.example.Zomato._Management.controller;

import com.example.Zomato._Management.dto.OrderDto;
import com.example.Zomato._Management.entity.Order;
import com.example.Zomato._Management.service.Impl.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderImpl service;
    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto>createOrders(@RequestBody OrderDto orderDto){
        OrderDto o=service.createitem(orderDto);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order>getitems(@PathVariable Long id ){
        Order o=service.getitems(id);
        return new ResponseEntity<>(o,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto>updateitemss(@PathVariable Long id ,@RequestBody OrderDto orderDto){
        OrderDto o=service.updateitems(id,orderDto);
        return new ResponseEntity<>(o,HttpStatus.OK);
    }
}
