package com.gamescenter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.gamescenter.dto.EventDTO;
import com.gamescenter.model.Event;

import jakarta.validation.Valid;

@Mapper (componentModel = "spring")
public interface EventMapper {
    EventDTO toDTO (Event event);
    List<EventDTO> toDTOs (List<Event> events);

    Event toEntity (EventDTO dto);
    List<Event> toEntities (List<EventDTO> dtos);

    void updateFromDTO(EventDTO dto, @MappingTarget Event event);
}
