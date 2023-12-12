package com.mega.demo.services;

import com.mega.demo.models.dto.ChannelResponse;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.CreateChannelRequest;
import com.mega.demo.models.dto.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelService {
    ChannelDto save(ChannelDto channelDto);
    ChannelDto findById(Long id);

    Response deleteChannel(Long id);
    Response createChannel(MultipartFile logo, CreateChannelRequest request);

    Integer getDiscountsPercent(Long channelId, int days);
    List<ChannelDto> getListById(List<Long> channelIds);

    ChannelResponse getAllByPageNum(int limit, int pageNum);

    ChannelDto getChannelById(Long channelId);
}