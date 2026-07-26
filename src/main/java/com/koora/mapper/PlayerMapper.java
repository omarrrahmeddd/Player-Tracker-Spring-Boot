package com.koora.mapper;

import com.koora.dto.PlayerResponseDTO;
import com.koora.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerResponseDTO toDto(Player player);
}