package com.example.Zepto_Mangement.service.Impl;

import com.example.Zepto_Mangement.dto.OrderDto;
import com.example.Zepto_Mangement.entity.Order;
import com.example.Zepto_Mangement.repository.OrderRepository;
import com.example.Zepto_Mangement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderRepository repository;


    @Override
    public OrderDto createorders(OrderDto orderDto) {
        Order order=new Order(
                orderDto.getId(),
                orderDto.getName(),
                orderDto.getDiscount(),
                orderDto.getPrice()
        );
        Order savedorder=repository.save(order);
        OrderDto saveorder=new OrderDto(
                savedorder.getId(),
                savedorder.getName(),
                savedorder.getDiscount(),
                savedorder.getPrice()
        );
        return  saveorder;
    }

    @Override
    public Order getorders(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found with id "));
    }

    @Override
    public OrderDto updateorders(Long id, OrderDto orderDto) {
        Order order=repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found"));
        order.setName(orderDto.getName());
        order.setPrice(orderDto.getPrice());
        order.setDiscount(orderDto.getDiscount());
        Order savedorder=repository.save(order);
        return new OrderDto(
                savedorder.getId(),
                savedorder.getName(),
                savedorder.getDiscount(),
                savedorder.getPrice()
        );

    }

    @Override
    public Order deleteorders(Long id) {
        Order order=repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found"));
        repository.delete(order);
        return  order;
    }
}
