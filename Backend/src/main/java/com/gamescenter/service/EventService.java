package com.gamescenter.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescenter.dto.EventDTO;
import com.gamescenter.mapper.EventMapper;
import com.gamescenter.model.Event;
import com.gamescenter.repository.EventRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private EventMapper eventMapper;

    public List<EventDTO> findAll() {
        return eventMapper.toDTOs(eventRepo.findAll());
    }

    public EventDTO findById(Long id) {
        Event event = eventRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id: " + id));
        return eventMapper.toDTO(event);
    }

    public EventDTO create(@Valid EventDTO dto) {
        Event event = eventMapper.toEntity(dto);

        event = eventRepo.save(event);
        return eventMapper.toDTO(event);
    }

    public EventDTO update(@Valid EventDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Event ID must not be null for update.");
        }

        Event event = eventRepo.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found."));

        eventMapper.updateFromDTO(dto, event);

        event = eventRepo.save(event);
        return eventMapper.toDTO(event);
    }

    public void deleteById(Long id) {
        eventRepo.deleteById(id);
    }

    public List<EventDTO> findByEventNameContaining(String name) {
        return eventMapper.toDTOs(eventRepo.findByEventNameContaining(name));
    }

    public List<EventDTO> findEventsBetween(LocalDateTime start, LocalDateTime end) {
        return eventMapper.toDTOs(eventRepo.findByEventStartBetween(start, end));
    }
}