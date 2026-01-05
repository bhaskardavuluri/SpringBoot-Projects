package com.example.Zomato._Management.service;

import com.example.Zomato._Management.dto.OrderDto;
import com.example.Zomato._Management.entity.Order;

public interface OrderService {
    OrderDto createitem(OrderDto orderDto);
    Order getitems(Long id );
    OrderDto updateitems(Long id ,OrderDto orderDto);
    Order   deleteitem(Long id);
}
