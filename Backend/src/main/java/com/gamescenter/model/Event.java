package com.gamescenter.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime eventStart;
    LocalDateTime eventEnd;

    @NotBlank
    String eventName;
    @NotBlank
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    Set<BookedTable> tables;
    int maxTables;
}