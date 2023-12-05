package com.mega.demo.dao;

import com.mega.demo.models.OrderChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderChannelRepository extends JpaRepository<OrderChannel, Long> {
    @Query("select oc from OrderChannel oc where oc.order.id =:id")
    List<OrderChannel> findByOrderId(@Param("id") Long id);
}
