package com.mega.demo.controllers;

import com.mega.demo.models.dto.CreateOrderRequest;
import com.mega.demo.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest informationRequest){
        return ResponseEntity.ok(orderService.createOrder(informationRequest));
    }

    @PostMapping("/delete")
    ResponseEntity<?> deleteOrder(@RequestParam Long id){
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
}