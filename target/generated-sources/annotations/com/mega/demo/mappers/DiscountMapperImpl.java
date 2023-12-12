package com.mega.demo.mappers;

import com.mega.demo.models.Channel;
import com.mega.demo.models.Discount;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import com.mega.demo.models.dto.entityDto.DiscountDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T18:39:46+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
public class DiscountMapperImpl implements DiscountMapper {

    @Override
    public Discount toEntity(DiscountDto dto) {
        if ( dto == null ) {
            return null;
        }

        Discount discount = new Discount();

        discount.setId( dto.getId() );
        discount.setPercent( dto.getPercent() );
        discount.setDefinition( dto.getDefinition() );
        discount.setMinDays( dto.getMinDays() );
        discount.setChannel( channelDtoToChannel( dto.getChannel() ) );

        return discount;
    }

    @Override
    public DiscountDto toDto(Discount entity) {
        if ( entity == null ) {
            return null;
        }

        DiscountDto discountDto = new DiscountDto();

        discountDto.setId( entity.getId() );
        discountDto.setPercent( entity.getPercent() );
        discountDto.setDefinition( entity.getDefinition() );
        discountDto.setMinDays( entity.getMinDays() );
        discountDto.setChannel( channelToChannelDto( entity.getChannel() ) );

        return discountDto;
    }

    @Override
    public List<Discount> toEntityList(List<DiscountDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Discount> list = new ArrayList<Discount>( dtos.size() );
        for ( DiscountDto discountDto : dtos ) {
            list.add( toEntity( discountDto ) );
        }

        return list;
    }

    @Override
    public List<DiscountDto> toDtoList(List<Discount> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DiscountDto> list = new ArrayList<DiscountDto>( entities.size() );
        for ( Discount discount : entities ) {
            list.add( toDto( discount ) );
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
}
