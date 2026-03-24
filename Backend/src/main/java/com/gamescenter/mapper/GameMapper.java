package com.gamescenter.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.gamescenter.dto.GameDTO;
import com.gamescenter.model.Game;

@Mapper (componentModel = "spring")
public interface GameMapper {
    GameDTO toDTO (Game game);
    List<GameDTO> toDTOs (List<Game> games);

    Game toEntity (GameDTO dto);
    List<Game> toEntities (List<GameDTO> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(GameDTO dto, @MappingTarget Game game);
}
