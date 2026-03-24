package com.gamescenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescenter.dto.BookedTableDTO;
import com.gamescenter.mapper.BookedTableMapper;
import com.gamescenter.model.BookedTable;
import com.gamescenter.model.Event;
import com.gamescenter.repository.BookedTableRepository;
import com.gamescenter.repository.EventRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class BookedTableService {

    @Autowired
    private BookedTableRepository tableRepo;

    @Autowired
    private BookedTableMapper mapper;

    @Autowired
    private EventRepository eventRepo;

    public List<BookedTableDTO> findAll() {
        return mapper.toDTOs(tableRepo.findAll());
    }

    public BookedTableDTO findById(Long id) {
        BookedTable table = tableRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BookedTable not found with id: " + id));
        return mapper.toDTO(table);
    }

    public BookedTableDTO create(@Valid BookedTableDTO dto) {
        BookedTable table = mapper.toEntity(dto);

        Event event = validateAndAttachEvent(dto.getEvent().getId());
        table.setEvent(event);

        table = tableRepo.save(table);
        return mapper.toDTO(table);
    }

    public BookedTableDTO update(@Valid BookedTableDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("BookedTable ID must not be null for update.");
        }

        BookedTable table = tableRepo.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("BookedTable not found."));

        mapper.updateFromDTO(dto, table);

        Event event = validateAndAttachEvent(dto.getEvent().getId());
        table.setEvent(event);

        //validateTable(table, event);

        table = tableRepo.save(table);
        return mapper.toDTO(table);
    }

    public void deleteById(Long id) {
        tableRepo.deleteById(id);
    }

    public List<BookedTableDTO> findByEventId(Long eventId) {
        return mapper.toDTOs(tableRepo.findByEventId(eventId));
    }

    public List<BookedTableDTO> findByGameId(Long gameId) {
        return mapper.toDTOs(tableRepo.findByGameId(gameId));
    }

    private Event validateAndAttachEvent(Long eventId) {
        return eventRepo.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id: " + eventId));
    }
}