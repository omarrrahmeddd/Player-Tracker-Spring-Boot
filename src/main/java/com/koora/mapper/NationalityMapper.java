package com.koora.mapper;

import com.koora.dto.NationalityResponseDTO;
import com.koora.entity.Nationality;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NationalityMapper {

    NationalityMapper INSTANCE = Mappers.getMapper(NationalityMapper.class);

    NationalityResponseDTO toDto(Nationality nationality);
}