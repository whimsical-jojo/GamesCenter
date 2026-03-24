package com.gamescenter.dto;

import java.time.LocalTime;

import com.gamescenter.model.GameAvailability;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {
    Long id;

    String title;
    String description;

    LocalTime duration;
    int minPlayers;
    int maxPlayers;
    int minAge;

    String image;

    int numAvailable;
    int numInStock;

    GameAvailability availability;
}
