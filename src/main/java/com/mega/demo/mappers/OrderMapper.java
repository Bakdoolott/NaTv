package com.mega.demo.mappers;

import com.mega.demo.models.Order;
import com.mega.demo.models.dto.entityDto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto> {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
}
