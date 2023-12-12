package com.mega.demo.mappers;

import com.mega.demo.models.Channel;
import com.mega.demo.models.Order;
import com.mega.demo.models.OrderChannel;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.entityDto.OrderChannelDto;
import com.mega.demo.models.dto.entityDto.OrderDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T18:39:46+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
public class OrderChannelMapperImpl implements OrderChannelMapper {

    @Override
    public OrderChannel toEntity(OrderChannelDto dto) {
        if ( dto == null ) {
            return null;
        }

        OrderChannel orderChannel = new OrderChannel();

        orderChannel.setId( dto.getId() );
        orderChannel.setChannel( channelDtoToChannel( dto.getChannel() ) );
        orderChannel.setOrder( orderDtoToOrder( dto.getOrder() ) );
        orderChannel.setPrice( dto.getPrice() );

        return orderChannel;
    }

    @Override
    public OrderChannelDto toDto(OrderChannel entity) {
        if ( entity == null ) {
            return null;
        }

        OrderChannelDto orderChannelDto = new OrderChannelDto();

        orderChannelDto.setId( entity.getId() );
        orderChannelDto.setChannel( channelToChannelDto( entity.getChannel() ) );
        orderChannelDto.setOrder( orderToOrderDto( entity.getOrder() ) );
        orderChannelDto.setPrice( entity.getPrice() );

        return orderChannelDto;
    }

    @Override
    public List<OrderChannel> toEntityList(List<OrderChannelDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<OrderChannel> list = new ArrayList<OrderChannel>( dtos.size() );
        for ( OrderChannelDto orderChannelDto : dtos ) {
            list.add( toEntity( orderChannelDto ) );
        }

        return list;
    }

    @Override
    public List<OrderChannelDto> toDtoList(List<OrderChannel> entities) {
        if ( entities == null ) {
            return null;
        }

        List<OrderChannelDto> list = new ArrayList<OrderChannelDto>( entities.size() );
        for ( OrderChannel orderChannel : entities ) {
            list.add( toDto( orderChannel ) );
        }

        return list;
    }

    protected Channel channelDtoToChannel(ChannelDto channelDto) {
        if ( channelDto == null ) {
            return null;
        }

        Channel channel = new Channel();

        channel.setId( channelDto.getId() );
        channel.setName( channelDto.getName() );
        channel.setLogo( channelDto.getLogo() );
        channel.setPrice( channelDto.getPrice() );
        channel.setAddDate( channelDto.getAddDate() );
        channel.setHasDiscount( channelDto.getHasDiscount() );
        channel.setPriority( channelDto.getPriority() );

        return channel;
    }

    protected Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDto.getId() );
        order.setAddDate( orderDto.getAddDate() );
        order.setText( orderDto.getText() );
        order.setPhone( orderDto.getPhone() );
        order.setEmail( orderDto.getEmail() );
        order.setFio( orderDto.getFio() );
        order.setTotalPrice( orderDto.getTotalPrice() );

        return order;
    }

    protected ChannelDto channelToChannelDto(Channel channel) {
        if ( channel == null ) {
            return null;
        }

        ChannelDto channelDto = new ChannelDto();

        channelDto.setId( channel.getId() );
        channelDto.setName( channel.getName() );
        channelDto.setLogo( channel.getLogo() );
        channelDto.setPrice( channel.getPrice() );
        channelDto.setAddDate( channel.getAddDate() );
        channelDto.setHasDiscount( channel.getHasDiscount() );
        channelDto.setPriority( channel.getPriority() );

        return channelDto;
    }

    protected OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setAddDate( order.getAddDate() );
        orderDto.setText( order.getText() );
        orderDto.setPhone( order.getPhone() );
        orderDto.setEmail( order.getEmail() );
        orderDto.setFio( order.getFio() );
        orderDto.setTotalPrice( order.getTotalPrice() );

        return orderDto;
    }
}
