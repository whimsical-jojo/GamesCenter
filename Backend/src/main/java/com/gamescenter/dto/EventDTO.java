package com.gamescenter.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EventDTO {
    Long id;

    LocalDateTime eventStart;
    LocalDateTime eventEnd;
    int maxTables;
    
    @NotBlank
    String eventName;
    @NotBlank
    String description;
}
