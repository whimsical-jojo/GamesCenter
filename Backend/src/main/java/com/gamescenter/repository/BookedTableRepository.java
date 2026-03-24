package com.gamescenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamescenter.model.BookedTable;

@Repository
public interface BookedTableRepository extends JpaRepository<BookedTable, Long>{

}
