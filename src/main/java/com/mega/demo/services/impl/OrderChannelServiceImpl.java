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
    public int createOrderChannel(OrderDto orderDto, List<Long> channelId, int days) {
        List<ChannelDto> channelDto = channelService.getListById(channelId);
        int totalPrice = 0;

        for(ChannelDto channelDto1: channelDto) {
            double price = 0;
            OrderChannelDto orderChannelDto = new OrderChannelDto();
            orderChannelDto.setOrder(orderDto);
            orderChannelDto.setChannel(channelDto1);

            int lengthOfWords = orderDto.getText().replaceAll("\\s", "").length();
            if (channelDto1.getPrice() > 0) {
                double integer = lengthOfWords * channelDto1.getPrice();
                Integer discountPrice = null;
                discountPrice = channelService.getDiscountsPercent(channelDto1.getId(), days);
                if (discountPrice != null) {
                    price = integer / 100 * discountPrice;
                }
                price = integer - price;
            }
            orderChannelDto.setPrice((int) price);
            totalPrice = totalPrice + (int) price;
            save(orderChannelDto);
        }

        return totalPrice;
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
