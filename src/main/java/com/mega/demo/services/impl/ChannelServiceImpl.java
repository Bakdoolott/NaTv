package com.mega.demo.services.impl;

import com.mega.demo.dao.ChannelRepository;
import com.mega.demo.exceptions.ChannelNotFoundException;
import com.mega.demo.exceptions.NotDeletedException;
import com.mega.demo.exceptions.UnsavedException;
import com.mega.demo.mappers.ChannelMapper;
import com.mega.demo.microservices.FileService;
import com.mega.demo.microservices.jsons.FileResponse;
import com.mega.demo.models.Channel;
import com.mega.demo.models.dto.ChannelDetailsResponse;
import com.mega.demo.models.dto.ChannelResponse;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.CreateChannelRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.services.ChannelService;
import com.mega.demo.utils.ResourceBundle;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository repository;
    private final FileService fileService;
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
    public Response createChannel(MultipartFile logo, CreateChannelRequest request) {
        try {
            System.out.println("test");
            ChannelDto channelDto = new ChannelDto();
            channelDto.setName(request.getName());

            FileResponse fileResponse=fileService.upload(logo);
           channelDto.setLogo(fileResponse.getDownloadUri());

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

    @Override
    public ChannelResponse getAllByPageNum(int limit, int pageNum) {

        Page<ChannelDetailsResponse> result=repository.getAllChannels( PageRequest.of(pageNum,limit));

        return ChannelResponse
                .builder()
                .resultList(result.toList())
                .totalCountOfChannels(result.getTotalElements())
                .build();
    }
}