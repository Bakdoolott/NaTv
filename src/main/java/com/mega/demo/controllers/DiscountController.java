package com.mega.demo.controllers;

import com.mega.demo.models.dto.CreateDiscountRequest;
import com.mega.demo.services.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
@AllArgsConstructor
public class DiscountController {
    private final DiscountService discountService;

    @PostMapping("/create")
    ResponseEntity<?> createDiscount(@RequestBody CreateDiscountRequest request){
        return ResponseEntity.ok(discountService.createDiscount(request));
    }

    @PostMapping("/delete/{discountId}")
    ResponseEntity<?> deleteDiscount(@PathVariable Long discountId){
        return ResponseEntity.ok(discountService.deleteDiscount(discountId));
    }
}
