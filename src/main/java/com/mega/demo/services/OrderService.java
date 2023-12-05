package com.mega.demo.services;

import com.mega.demo.models.dto.CreateOrderRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.models.dto.entityDto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto save(OrderDto orderDto);
    Response createOrder(CreateOrderRequest request);
    OrderDto findById(Long id);
    Response deleteOrder(Long orderId);

}
