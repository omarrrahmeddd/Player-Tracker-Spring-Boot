package com.koora.mapper;

import com.koora.dto.ClubResponseDTO;
import com.koora.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClubMapper {

    ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);


    ClubResponseDTO toDto(Club club);
}