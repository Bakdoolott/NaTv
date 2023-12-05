package com.mega.demo.dao;

import com.mega.demo.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    @Query("select d from Discount d join Channel c on d.channel.id = c.id where c.id = :id")
    Discount findDiscountByChannelId(@Param("id") Long id);
}