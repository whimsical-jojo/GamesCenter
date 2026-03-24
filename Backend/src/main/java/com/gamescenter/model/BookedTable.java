package com.gamescenter.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

//TODO fix this because there's some db fuckery going on
@Data
@Entity
public class BookedTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //Each player can have booked many tables in the past (but only one per event)
    @ManyToMany(cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, fetch = FetchType.LAZY)
    @JoinTable( name = "booked_table_players",
                joinColumns = @JoinColumn(name = "booked_table_id"),
                inverseJoinColumns = @JoinColumn(name = "player_id"))
    Set<SiteUser> players;

    @ManyToOne(cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, fetch = FetchType.EAGER)
    @JoinColumn(name="host_id")
    SiteUser host;


    @OneToOne(fetch = FetchType.EAGER)
    Game game;

    @ManyToOne
    @JoinColumn(name="event_id")
    Event event;

    LocalDateTime startTime;

}
