package com.mega.demo.mappers;



import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public interface BaseMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);

    List<ENTITY> toEntityList(List<DTO> dtos);
    List<DTO> toDtoList(List<ENTITY> entities);
}
