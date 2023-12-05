package com.mega.demo.dao;

import com.mega.demo.models.Order;
import com.mega.demo.models.dto.entityDto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
