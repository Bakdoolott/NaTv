package com.mega.demo.models;

import com.mega.demo.models.enums.HasDiscount;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_channel")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    String logo;
    Integer price;
    Date addDate;

    HasDiscount hasDiscount;

    String priority;

    @PrePersist
    void onCreate() {
        addDate = new Date();
        hasDiscount = HasDiscount.FALSE;
    }
}
