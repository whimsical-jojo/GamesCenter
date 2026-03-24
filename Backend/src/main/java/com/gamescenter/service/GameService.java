package com.gamescenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescenter.dto.GameDTO;
import com.gamescenter.mapper.GameMapper;
import com.gamescenter.model.Game;
import com.gamescenter.model.GameAvailability;
import com.gamescenter.repository.GameRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/**
 * TODO only admins should be allowed to change certain things about the game
 */
@Service
public class GameService {
    @Autowired 
    GameRepository gameRepo;

    @Autowired
    private GameMapper mapper;

    public List<GameDTO> findAll() {
        return mapper.toDTOs(gameRepo.findAll());
    }

    public GameDTO findById(Long id) {
        Game game = gameRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
        return mapper.toDTO(game);
    }

    public GameDTO create(@Valid GameDTO gameDTO) {
        Game game = mapper.toEntity(gameDTO);
        game = gameRepo.save(game);
        return mapper.toDTO(game);
    }

    public void deleteById(Long id) {
        gameRepo.deleteById(id);
    }

    public List<GameDTO> findByTitleContaining(String title) {
        return mapper.toDTOs(gameRepo.findByTitleContaining(title));
    }

    public List<GameDTO> findByAvailability(GameAvailability availability) {
        return mapper.toDTOs(gameRepo.findByAvailability(availability));
    }

    public GameDTO update(GameDTO dto) {
        Game game = gameRepo.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Game not found."));

        mapper.updateFromDTO(dto, game);
        game = gameRepo.save(game);

        return mapper.toDTO(game);
    }
}
