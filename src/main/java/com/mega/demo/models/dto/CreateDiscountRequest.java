package com.mega.demo.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateDiscountRequest {
    Integer percent;
    String definition;
    int minDays;
    Long channelId;
}