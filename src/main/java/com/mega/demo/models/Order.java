package com.mega.demo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Date startDate;
    Date endDate;
    Date addDate;
    String text;
    String phone;
    String email;
    String fio;
    int totalPrice;


    @PrePersist
    void onCreate(){
        addDate = new Date();
    }
}
