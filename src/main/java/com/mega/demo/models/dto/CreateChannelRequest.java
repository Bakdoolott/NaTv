package com.mega.demo.models.dto;

import com.mega.demo.models.enums.HasDiscount;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateChannelRequest {
    String name;
    String logo;
    Integer price;
    String priority;
}
