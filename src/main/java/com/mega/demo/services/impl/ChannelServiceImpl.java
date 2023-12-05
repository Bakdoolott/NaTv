package com.mega.demo.services.impl;

import com.mega.demo.dao.ChannelRepository;
import com.mega.demo.exceptions.ChannelNotFoundException;
import com.mega.demo.exceptions.NotDeletedException;
import com.mega.demo.exceptions.UnsavedException;
import com.mega.demo.mappers.ChannelMapper;
import com.mega.demo.models.Channel;
import com.mega.demo.models.Discount;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.CreateChannelRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.services.ChannelService;
import com.mega.demo.utils.ResourceBundle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository repository;
    @Override
    public ChannelDto save(ChannelDto channelDto) {
        Channel channel = ChannelMapper.MAPPER.toEntity(channelDto);
        channel = repository.save(channel);
        return ChannelMapper.MAPPER.toDto(channel);
    }

    @Override
    public ChannelDto findById(Long id){
        return ChannelMapper.MAPPER.toDto(
                repository.findById(id).orElse(null));
    }
    @Override
    public Response deleteChannel(Long id) {
        ChannelDto channelDto = findById(id);
        if(channelDto == null){
            throw new ChannelNotFoundException(ResourceBundle.periodMessages("channelNotFound"));
        }
        try {
            repository.delete(ChannelMapper.MAPPER.toEntity(channelDto));
        }catch (Exception e){
            throw new NotDeletedException(ResourceBundle.periodMessages("thereIsDiscount"));
        }
        return new Response("Deleted");
    }

    @Override
    public Response createChannel(CreateChannelRequest request) {
        try {
            ChannelDto channelDto = new ChannelDto();
            channelDto.setName(request.getName());
            channelDto.setLogo(request.getLogo());
            channelDto.setPrice(request.getPrice());
            channelDto.setPriority(request.getPriority());
            save(channelDto);
        }catch (Exception e){
            throw new UnsavedException(ResourceBundle.periodMessages("unsavedException"));
        }
        return new Response("Success");
    }

    @Override
    public Integer getDiscountsPercent(Long channelId, int days) {
        System.out.println("test" + channelId + days);
        Integer result = repository.getDiscountsValueByChannelId(channelId, days);
        System.out.println(result);
        return result;
    }

    @Override
    public List<ChannelDto> getListById(List<Long> channelIds) {
        return ChannelMapper.MAPPER.toDtoList(
                repository.findAllById(channelIds));
    }
}