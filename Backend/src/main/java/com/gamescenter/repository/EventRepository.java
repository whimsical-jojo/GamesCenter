package com.gamescenter.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescenter.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    List<Event> findByEventNameContaining(String name);

    List<Event> findByEventStartBetween(LocalDateTime start, LocalDateTime end);

}
