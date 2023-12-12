package com.mega.demo.services;

import com.mega.demo.models.dto.CreateOrderRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.models.dto.entityDto.OrderDto;

public interface OrderService {
    OrderDto save(OrderDto orderDto);
    Response createOrder(CreateOrderRequest informationRequest);
    OrderDto findById(Long id);
    Response deleteOrder(Long orderId);

}
