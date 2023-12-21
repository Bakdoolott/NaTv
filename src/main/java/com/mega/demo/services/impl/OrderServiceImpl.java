package com.mega.demo.services.impl;

import com.mega.demo.dao.OrderRepository;
import com.mega.demo.exceptions.NotDeletedException;
import com.mega.demo.exceptions.WrongDateException;
import com.mega.demo.mappers.OrderMapper;
import com.mega.demo.models.dto.CreateOrderRequest;
import com.mega.demo.models.dto.CreateOrderHelperRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.models.dto.entityDto.OrderDto;
import com.mega.demo.services.OrderChannelService;
import com.mega.demo.services.OrderService;
import com.mega.demo.utils.ResourceBundle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderChannelService orderChannelService;
    private final OrderRepository repository;

    @Override
    public OrderDto save(OrderDto orderDto) {
        return OrderMapper.MAPPER.toDto(repository
                .save(OrderMapper.MAPPER.toEntity(orderDto)));
    }

    @Override
    public Response createOrder(CreateOrderRequest informationRequest) {
        int totalPrice;
        for(CreateOrderHelperRequest request: informationRequest.getChannels()) {
            OrderDto orderDto = new OrderDto();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            int days = 0;
            try {
                List<Date> dates = new ArrayList<>();
                for(String date: request.getDates()){
                    dates.add(simpleDateFormat.parse((date)));
                    days ++;
                }
                orderDto.setDates(dates);
            } catch (ParseException e) {
                throw new WrongDateException(ResourceBundle.periodMessages("wrongDate"));
            }


            orderDto.setText(informationRequest.getText());
            orderDto.setPhone(informationRequest.getPhone());
            orderDto.setEmail(informationRequest.getEmail());
            orderDto.setFio(informationRequest.getFio());
            orderDto = save(orderDto);
            totalPrice = orderChannelService.createOrderChannel(orderDto, request.getChannelId(), days);
            orderDto.setTotalPrice(orderDto.getTotalPrice() + totalPrice);
            save(orderDto);
        }
        return new Response("Success");
    }

    @Override
    public OrderDto findById(Long id) {
        return OrderMapper.MAPPER.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public Response deleteOrder(Long orderId) {
        OrderDto orderDto = findById(orderId);
        try {
            orderChannelService.deleteByOrderId(orderId);
            repository.delete(OrderMapper.MAPPER.toEntity(orderDto));
        }catch (Exception e){
            throw new NotDeletedException(ResourceBundle.periodMessages("notDeletedException"));
        }
        return new Response("Deleted");
    }
}