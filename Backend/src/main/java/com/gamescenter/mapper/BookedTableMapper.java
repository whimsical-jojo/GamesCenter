package com.gamescenter.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.gamescenter.dto.BookedTableDTO;
import com.gamescenter.model.BookedTable;

@Mapper (componentModel = "spring")
public interface BookedTableMapper {
    BookedTableDTO toDTO (BookedTable bookedTable);
    List<BookedTableDTO> toDTOs (List<BookedTable> bookedTables);

    BookedTable toEntity (BookedTableDTO dto);
    List<BookedTable> toEntities (List<BookedTableDTO> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDTO(BookedTableDTO dto, @MappingTarget BookedTable bookedTable);
}