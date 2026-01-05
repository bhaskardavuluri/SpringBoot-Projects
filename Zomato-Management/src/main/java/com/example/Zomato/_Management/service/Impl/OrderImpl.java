package com.example.Zomato._Management.service.Impl;

import com.example.Zomato._Management.dto.OrderDto;
import com.example.Zomato._Management.entity.Order;
import com.example.Zomato._Management.repository.OrderRepository;
import com.example.Zomato._Management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public OrderDto createitem(OrderDto orderDto) {
        Order order = new Order(
                orderDto.getId(),
                orderDto.getItem_name(),
                orderDto.getItem_price()
        );
        Order savedorder = repository.save(order);
        OrderDto saveorder = new OrderDto(
                savedorder.getId(),
                savedorder.getItem_name(),
                savedorder.getItem_price()
        );
        return saveorder;


    }
    public  Order getitems(Long id ){
     return repository.findById(id)
             .orElseThrow(()->new RuntimeException("order not found with id "));

    }

    @Override
    public OrderDto updateitems(Long id, OrderDto orderDto) {
        Order order=repository.findById(id)
                .orElseThrow(()->new RuntimeException("order does not found with the given id "));
        order.setItem_name(order.getItem_name());
        order.setItem_price(order.getItem_price());
        Order updatedorder=repository.save(order);
        return new OrderDto(
                updatedorder.getId(),
                updatedorder.getItem_name(),
                updatedorder.getItem_price()
        );

    }
    public Order deleteitem(Long id ){
        Order order=  repository.findById(id)
                .orElseThrow(()->new RuntimeException("item not found with specific order"));
        repository.delete(order);
        return order;
    }
}
