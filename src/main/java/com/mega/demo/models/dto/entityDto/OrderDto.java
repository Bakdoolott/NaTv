package com.mega.demo.models.dto.entityDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    List<Date> dates;
    Date addDate;
    String text;
    String phone;
    String email;
    String fio;
    int totalPrice;
}
