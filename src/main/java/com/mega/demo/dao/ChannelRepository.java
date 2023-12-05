package com.mega.demo.dao;

import com.mega.demo.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    @Query(value = "SELECT d.percent FROM tb_discount d WHERE (d.channel_id = :id AND d.min_days < :days) ORDER BY d.min_days DESC LIMIT 1", nativeQuery = true)
    Integer getDiscountsValueByChannelId(@Param("id") Long id, @Param("days") int days);
}