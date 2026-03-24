package com.gamescenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescenter.model.Game;
import com.gamescenter.model.GameAvailability;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

    List<Game> findByAvailability(GameAvailability availability);

    List<Game> findByTitleContaining(String title);

}

