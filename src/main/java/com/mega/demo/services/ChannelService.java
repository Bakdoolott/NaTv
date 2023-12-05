package com.mega.demo.services;

import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.CreateChannelRequest;
import com.mega.demo.models.dto.Response;

import java.util.List;

public interface ChannelService {
    ChannelDto save(ChannelDto channelDto);
    ChannelDto findById(Long id);

    Response deleteChannel(Long id);
    Response createChannel(CreateChannelRequest request);

    Integer getDiscountsPercent(Long channelId, int days);
    List<ChannelDto> getListById(List<Long> channelIds);
}