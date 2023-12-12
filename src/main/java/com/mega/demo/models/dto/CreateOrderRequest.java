package com.mega.demo.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderRequest {
    String text;
    String phone;
    String email;
    String fio;
    List<CreateOrderHelperRequest> channels;
}
