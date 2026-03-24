package com.gamescenter.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String description;

    LocalTime duration;
    int maxPlayers;
    int minAge;

    String image;

    @Min(0)
    int numInStock;
    @Min(0)
    int numAvailable;
    @Enumerated(EnumType.STRING)
    GameAvailability availability;
}
