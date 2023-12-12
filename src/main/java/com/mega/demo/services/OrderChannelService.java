package com.mega.demo.services;

import com.mega.demo.models.dto.entityDto.OrderChannelDto;
import com.mega.demo.models.dto.entityDto.OrderDto;

import java.util.List;

public interface OrderChannelService {
    OrderChannelDto save(OrderChannelDto orderChannelDto);
    int createOrderChannel(OrderDto orderDto, Long channelId, int days);
    void deleteByOrderId(Long orderId);
}
