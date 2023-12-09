package com.mega.demo.models.dto;

import com.mega.demo.models.enums.HasDiscount;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateChannelRequest {
    String name;
    MultipartFile logo;
    Integer price;
    String priority;
}
