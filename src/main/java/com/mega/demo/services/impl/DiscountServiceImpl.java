package com.mega.demo.services.impl;

import com.mega.demo.dao.DiscountRepository;
import com.mega.demo.exceptions.NotFoundException;
import com.mega.demo.exceptions.UnsavedException;
import com.mega.demo.mappers.DiscountMapper;
import com.mega.demo.models.dto.CreateDiscountRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.entityDto.DiscountDto;
import com.mega.demo.models.enums.HasDiscount;
import com.mega.demo.services.ChannelService;
import com.mega.demo.services.DiscountService;
import com.mega.demo.utils.ResourceBundle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository repository;
    private final ChannelService channelService;
    @Override
    public DiscountDto save(DiscountDto discountDto) {
        return DiscountMapper.MAPPER.toDto(
                repository.save(DiscountMapper.MAPPER.toEntity(discountDto)));
    }

    @Override
    public Response deleteDiscount(Long discountId) {
        DiscountDto discountDto = findById(discountId);
        ChannelDto channelDto = channelService.findById(discountDto.getChannel().getId());
        repository.delete(DiscountMapper.MAPPER.toEntity(discountDto));
        DiscountDto discountDto1 = DiscountMapper.MAPPER.toDto(repository.findDiscountByChannelId(channelDto.getId()));
        if(discountDto1 == null){
            channelDto.setHasDiscount(HasDiscount.FALSE);
            channelService.save(channelDto);
        }
        return new Response("Deleted");
    }

    @Override
    public Response createDiscount(CreateDiscountRequest request) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setPercent(request.getPercent());
        discountDto.setDefinition(request.getDefinition());
        discountDto.setMinDays(request.getMinDays());

        ChannelDto channelDto = channelService.findById(request.getChannelId());
        if(channelDto == null)
            throw new NotFoundException(ResourceBundle.periodMessages("ChannelNotFound"));
        channelDto.setHasDiscount(HasDiscount.TRUE);
        channelDto = channelService.save(channelDto);

        discountDto.setChannel(channelDto);
        if(save(discountDto) == null){
            throw new UnsavedException(ResourceBundle.periodMessages("unsavedException"));
        }
        return new Response("Success");
    }

    @Override
    public DiscountDto findById(Long id) {
        return DiscountMapper.MAPPER.toDto(
                repository.findById(id).orElse(null));
    }
}