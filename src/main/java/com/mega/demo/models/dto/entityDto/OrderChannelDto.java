package com.mega.demo.models.dto.entityDto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderChannelDto {
    Long id;
    ChannelDto channel;
    OrderDto order;
    Integer price;
}
