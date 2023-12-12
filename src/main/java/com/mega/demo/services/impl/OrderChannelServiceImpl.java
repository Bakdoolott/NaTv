package com.mega.demo.services.impl;

import com.mega.demo.dao.OrderChannelRepository;
import com.mega.demo.mappers.OrderChannelMapper;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.entityDto.OrderChannelDto;
import com.mega.demo.models.dto.entityDto.OrderDto;
import com.mega.demo.services.ChannelService;
import com.mega.demo.services.OrderChannelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderChannelServiceImpl implements OrderChannelService {
    private final ChannelService channelService;
    private final OrderChannelRepository repository;
    @Override
    public OrderChannelDto save(OrderChannelDto orderChannelDto) {
        return OrderChannelMapper.MAPPER.toDto(repository
                .save(OrderChannelMapper.MAPPER.toEntity(orderChannelDto)));
    }

    @Override
    public int createOrderChannel(OrderDto orderDto, Long channelId, int days) {
        ChannelDto channelDto = channelService.getChannelById(channelId);

        double price = 0;
        OrderChannelDto orderChannelDto = new OrderChannelDto();
        orderChannelDto.setOrder(orderDto);
        orderChannelDto.setChannel(channelDto);

        int lengthOfWords = orderDto.getText().replaceAll("\\s", "").length();
        if (channelDto.getPrice() > 0) {
            double integer = lengthOfWords * channelDto.getPrice();
            Integer discountPrice;
            discountPrice = channelService.getDiscountsPercent(channelDto.getId(), days);
            if (discountPrice != null) {
                price = integer / 100 * discountPrice;
            }
            price = integer - price;
        }
        orderChannelDto.setPrice((int) price * days);
        save(orderChannelDto);

        return orderChannelDto.getPrice();
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        List<OrderChannelDto> orderChannelDto = OrderChannelMapper.MAPPER.toDtoList(
                repository.findByOrderId(orderId));
        System.out.println(orderChannelDto);
        for(OrderChannelDto orderChannelDto1: orderChannelDto) {
            repository.delete(OrderChannelMapper.MAPPER.toEntity(orderChannelDto1));
        }
    }
}
