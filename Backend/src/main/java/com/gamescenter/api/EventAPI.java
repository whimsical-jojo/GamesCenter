package com.gamescenter.api;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamescenter.dto.EventDTO;
import com.gamescenter.service.EventService;

@RestController
@RequestMapping("api/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventAPI {

    @Autowired
    private EventService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EventDTO dto) {
        try {
            return ResponseEntity.status(201).body(service.create(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody EventDTO dto) {
        try {
            dto.setId(id);
            return ResponseEntity.ok(service.update(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    //TODO search could be improved later on with proper filters
    @GetMapping
    public ResponseEntity<List<EventDTO>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDateTime start,
            @RequestParam(required = false) LocalDateTime end) {

        if (name != null) {
            return ResponseEntity.ok(service.findByEventNameContaining(name));
        }

        if (start != null && end != null) {
            return ResponseEntity.ok(service.findEventsBetween(start, end));
        }

        return ResponseEntity.ok(service.findAll());
    }
}