package com.example.Swiggy_Mangement.service.Impl;

import com.example.Swiggy_Mangement.dto.OrderDto;
import com.example.Swiggy_Mangement.entity.Order;
import com.example.Swiggy_Mangement.repository.OrderRepository;
import com.example.Swiggy_Mangement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public OrderDto createitems(OrderDto orderDto) {
        Order order=new Order(
                orderDto.getId(),
                orderDto.getAddress(),
                orderDto.getName(),
                orderDto.getPrice()
        );
        Order savedorder=repository.save(order);
        OrderDto saveorder=new OrderDto(
                savedorder.getId(),
                savedorder.getAddress(),
                savedorder.getName(),
                savedorder.getPrice()
        );
        return  saveorder;
    }

    @Override
    public Order getitems(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found with id"));
    }

    @Override
    public OrderDto updateitems(Long id, OrderDto orderDto) {
        Order order=repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found "));
        order.setAddress(orderDto.getAddress());
        order.setName(orderDto.getName());
        order.setPrice(orderDto.getPrice());
        Order savedorder=repository.save(order);
        return new OrderDto(
                savedorder.getId(),
                savedorder.getAddress(),
                savedorder.getName(),
                savedorder.getPrice()
        );
    }

    @Override
    public Order delete(Long id) {
        Order order=repository.findById(id)
                .orElseThrow(()->new RuntimeException("order not found with id"));
        repository.delete(order);
        return  order;
    }
}
