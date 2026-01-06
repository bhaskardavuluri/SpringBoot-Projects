package com.example.Swiggy_Mangement.service;

import com.example.Swiggy_Mangement.dto.OrderDto;
import com.example.Swiggy_Mangement.entity.Order;

public interface OrderService {
    OrderDto createitems(OrderDto orderDto);
    Order getitems(Long id);
    OrderDto updateitems(Long id ,OrderDto orderDto);
    Order delete(Long id);
}
