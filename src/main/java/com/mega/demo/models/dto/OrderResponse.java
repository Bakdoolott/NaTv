package com.mega.demo.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    int totalPrice;
    int totalPriceWithDiscount;
    List<> channels;
}
