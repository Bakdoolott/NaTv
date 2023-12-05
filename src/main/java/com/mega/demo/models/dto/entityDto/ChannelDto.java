package com.mega.demo.models.dto.entityDto;

import com.mega.demo.models.enums.HasDiscount;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDto {
    Long id;
    String name;
    String logo;
    Integer price;
    Date addDate;
    HasDiscount hasDiscount;
    String priority;

}
