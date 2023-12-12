package com.mega.demo.mappers;

import com.mega.demo.models.Channel;
import com.mega.demo.models.dto.entityDto.ChannelDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T18:39:46+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
public class ChannelMapperImpl implements ChannelMapper {

    @Override
    public Channel toEntity(ChannelDto dto) {
        if ( dto == null ) {
            return null;
        }

        Channel channel = new Channel();

        channel.setId( dto.getId() );
        channel.setName( dto.getName() );
        channel.setLogo( dto.getLogo() );
        channel.setPrice( dto.getPrice() );
        channel.setAddDate( dto.getAddDate() );
        channel.setHasDiscount( dto.getHasDiscount() );
        channel.setPriority( dto.getPriority() );

        return channel;
    }

    @Override
    public ChannelDto toDto(Channel entity) {
        if ( entity == null ) {
            return null;
        }

        ChannelDto channelDto = new ChannelDto();

        channelDto.setId( entity.getId() );
        channelDto.setName( entity.getName() );
        channelDto.setLogo( entity.getLogo() );
        channelDto.setPrice( entity.getPrice() );
        channelDto.setAddDate( entity.getAddDate() );
        channelDto.setHasDiscount( entity.getHasDiscount() );
        channelDto.setPriority( entity.getPriority() );

        return channelDto;
    }

    @Override
    public List<Channel> toEntityList(List<ChannelDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Channel> list = new ArrayList<Channel>( dtos.size() );
        for ( ChannelDto channelDto : dtos ) {
            list.add( toEntity( channelDto ) );
        }

        return list;
    }

    @Override
    public List<ChannelDto> toDtoList(List<Channel> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ChannelDto> list = new ArrayList<ChannelDto>( entities.size() );
        for ( Channel channel : entities ) {
            list.add( toDto( channel ) );
        }

        return list;
    }
}
