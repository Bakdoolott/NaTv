package com.mega.demo.models.dto.entityDto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountDto {
    Long id;
    Integer percent;
    String definition;
    int minDays;

    ChannelDto channel;
}
