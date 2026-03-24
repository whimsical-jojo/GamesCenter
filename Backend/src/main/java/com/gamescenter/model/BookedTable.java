package com.gamescenter.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class BookedTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Set<SiteUser> players;

    @OneToOne(fetch = FetchType.EAGER)
    SiteUser staff;


    @OneToOne(fetch = FetchType.EAGER)
    Game game;

    LocalDateTime startTime;

}
