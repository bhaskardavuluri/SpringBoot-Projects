package com.example.Zepto_Mangement.service;

import com.example.Zepto_Mangement.dto.OrderDto;
import com.example.Zepto_Mangement.entity.Order;

public interface OrderService {
    OrderDto createorders(OrderDto orderDto);
    Order getorders(Long id);
    OrderDto updateorders(Long id,OrderDto orderDto);
    Order deleteorders(Long id );
}
