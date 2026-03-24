package com.gamescenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescenter.model.BookedTable;

@Repository
public interface BookedTableRepository extends JpaRepository<BookedTable, Long>{

    List<BookedTable> findByEventId(Long eventId);

    List<BookedTable> findByGameId(Long gameId);

    Optional<BookedTable> findByHostIdAndEventId(Long hostId, Long eventId);

}
