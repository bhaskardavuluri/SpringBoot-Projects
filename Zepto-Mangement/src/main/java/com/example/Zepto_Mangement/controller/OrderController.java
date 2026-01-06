package com.example.Zepto_Mangement.controller;

import com.example.Zepto_Mangement.dto.OrderDto;
import com.example.Zepto_Mangement.entity.Order;
import com.example.Zepto_Mangement.service.Impl.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderImpl  service;
    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> createitems(@RequestBody OrderDto orderDto){
        OrderDto o=service.createorders(orderDto);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order>getitems(@PathVariable Long id ){
        Order o=service.getorders(id);
        return new ResponseEntity<>(o,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto>updateitems(@PathVariable Long id,@RequestBody OrderDto orderDto){
        OrderDto o=service.updateorders(id,orderDto);
        return  new ResponseEntity<>(o,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteitems(@PathVariable Long id ){
        Order o=service.deleteorders(id);
        return ResponseEntity.ok("order deleted successfully");
    }
}
