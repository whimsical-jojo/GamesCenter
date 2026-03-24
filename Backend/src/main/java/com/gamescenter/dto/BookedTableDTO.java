package com.gamescenter.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.gamescenter.model.SiteUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookedTableDTO {
    Long id;

    Set<SiteUserDTO> players;
    SiteUser host;
    GameDTO game;
    EventDTO event;
    LocalDateTime startTime;
}
