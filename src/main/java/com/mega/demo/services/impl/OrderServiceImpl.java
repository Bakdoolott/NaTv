package com.mega.demo.services.impl;

import com.mega.demo.dao.OrderRepository;
import com.mega.demo.exceptions.NotDeletedException;
import com.mega.demo.exceptions.UnknownException;
import com.mega.demo.exceptions.WrongDateException;
import com.mega.demo.mappers.OrderMapper;
import com.mega.demo.models.dto.CreateOrderRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.models.dto.entityDto.OrderChannelDto;
import com.mega.demo.models.dto.entityDto.OrderDto;
import com.mega.demo.services.OrderChannelService;
import com.mega.demo.services.OrderService;
import com.mega.demo.utils.ResourceBundle;
import com.sun.source.tree.TryTree;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public Response createOrder(CreateOrderRequest request) {
        OrderDto orderDto = new OrderDto();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            orderDto.setStartDate(simpleDateFormat.parse(request.getStartDate()));
            orderDto.setEndDate(simpleDateFormat.parse(request.getEndDate()));
        } catch (ParseException e) {
            throw new WrongDateException(ResourceBundle.periodMessages("wrongDate"));
        }

        orderDto.setText(request.getText());
        orderDto.setPhone(request.getPhone());
        orderDto.setEmail(request.getEmail());
        orderDto.setFio(request.getFio());
        orderDto = save(orderDto);
        int days = 0;
        try {
            days = (int) (orderDto.getEndDate().getTime() - orderDto.getStartDate().getTime()) / 86400000;
        }catch (Exception e){
            throw new UnknownException(ResourceBundle.periodMessages("unknownException"));
        }
        int orderChannelDtosPrice = orderChannelService.createOrderChannel(orderDto, request.getChannelId(), days);
        orderDto.setTotalPrice(orderDto.getTotalPrice() + orderChannelDtosPrice);
        save(orderDto);
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