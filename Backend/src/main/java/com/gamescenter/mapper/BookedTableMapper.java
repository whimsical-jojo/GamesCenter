package com.gamescenter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.gamescenter.dto.BookedTableDTO;
import com.gamescenter.model.BookedTable;

@Mapper (componentModel = "spring")
public interface BookedTableMapper {
    BookedTableDTO toDTO (BookedTable bookedTable);
    List<BookedTableDTO> toDTOs (List<BookedTable> bookedTables);

    BookedTable toEntity (BookedTableDTO dto);
    List<BookedTable> toEntities (List<BookedTableDTO> dtos);

    void updateFromDTO(BookedTableDTO dto, @MappingTarget BookedTable bookedTable);
}