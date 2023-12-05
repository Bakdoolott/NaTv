package com.mega.demo.mappers;

import com.mega.demo.models.OrderChannel;
import com.mega.demo.models.dto.entityDto.OrderChannelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderChannelMapper extends BaseMapper<OrderChannel, OrderChannelDto> {
    OrderChannelMapper MAPPER = Mappers.getMapper(OrderChannelMapper.class);
}
