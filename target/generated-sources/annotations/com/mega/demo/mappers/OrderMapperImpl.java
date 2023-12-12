package com.mega.demo.mappers;

import com.mega.demo.models.Order;
import com.mega.demo.models.dto.entityDto.OrderDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T18:39:46+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setAddDate( dto.getAddDate() );
        order.setText( dto.getText() );
        order.setPhone( dto.getPhone() );
        order.setEmail( dto.getEmail() );
        order.setFio( dto.getFio() );
        order.setTotalPrice( dto.getTotalPrice() );

        return order;
    }

    @Override
    public OrderDto toDto(Order entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( entity.getId() );
        orderDto.setAddDate( entity.getAddDate() );
        orderDto.setText( entity.getText() );
        orderDto.setPhone( entity.getPhone() );
        orderDto.setEmail( entity.getEmail() );
        orderDto.setFio( entity.getFio() );
        orderDto.setTotalPrice( entity.getTotalPrice() );

        return orderDto;
    }

    @Override
    public List<Order> toEntityList(List<OrderDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtos.size() );
        for ( OrderDto orderDto : dtos ) {
            list.add( toEntity( orderDto ) );
        }

        return list;
    }

    @Override
    public List<OrderDto> toDtoList(List<Order> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( entities.size() );
        for ( Order order : entities ) {
            list.add( toDto( order ) );
        }

        return list;
    }
}
