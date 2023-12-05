package com.mega.demo.models.dto.entityDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    Date startDate;
    Date endDate;
    Date addDate;
    String text;
    String phone;
    String email;
    String fio;
    int totalPrice;
}
