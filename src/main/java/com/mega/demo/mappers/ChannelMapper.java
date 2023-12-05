package com.mega.demo.mappers;

import com.mega.demo.models.Channel;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel, ChannelDto> {
    ChannelMapper MAPPER = Mappers.getMapper(ChannelMapper.class);
}
