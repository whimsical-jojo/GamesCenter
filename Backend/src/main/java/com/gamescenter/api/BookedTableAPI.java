package com.gamescenter.api;

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

import com.gamescenter.dto.BookedTableDTO;
import com.gamescenter.service.BookedTableService;

@RestController
@RequestMapping("api/booked-tables")
@CrossOrigin(origins = "http://localhost:4200")
public class BookedTableAPI {

    @Autowired
    private BookedTableService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookedTableDTO dto) {
        try {
            return ResponseEntity.status(201).body(service.create(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody BookedTableDTO dto) {
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
    public ResponseEntity<BookedTableDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookedTableDTO>> search(
            @RequestParam(required = false) Long eventId,
            @RequestParam(required = false) Long gameId) {

        if (eventId != null) {
            return ResponseEntity.ok(service.findByEventId(eventId));
        }

        if (gameId != null) {
            return ResponseEntity.ok(service.findByGameId(gameId));
        }

        return ResponseEntity.ok(service.findAll());
    }
}