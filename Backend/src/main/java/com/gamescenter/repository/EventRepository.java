package com.gamescenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescenter.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
