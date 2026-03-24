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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class BookedTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, mappedBy = "bookedTable", fetch = FetchType.LAZY)
    Set<SiteUser> players;

    @OneToOne(cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, mappedBy = "bookedTable", fetch = FetchType.EAGER)
    SiteUser host;


    @OneToOne(fetch = FetchType.EAGER)
    Game game;

    @ManyToOne
    @JoinColumn(name="event_id")
    Event event;

    LocalDateTime startTime;

}
