package com.mega.demo.mappers;

import com.mega.demo.models.Discount;
import com.mega.demo.models.dto.entityDto.DiscountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper extends BaseMapper<Discount, DiscountDto> {
    DiscountMapper MAPPER = Mappers.getMapper(DiscountMapper.class);
}
