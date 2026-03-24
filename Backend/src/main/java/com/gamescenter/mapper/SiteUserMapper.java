package com.gamescenter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gamescenter.dto.SiteUserDTO;
import com.gamescenter.model.SiteUser;

@Mapper (componentModel = "spring")
public interface SiteUserMapper {
    @Mapping(target = "password", ignore = true)
    SiteUserDTO toDTO (SiteUser user);
    List<SiteUserDTO> toDTOs (List<SiteUser> users);

    SiteUser toEntity (SiteUserDTO dto);
    List<SiteUser> toEntities (List<SiteUserDTO> dtos);

    void updateFromDTO(SiteUserDTO dto, @MappingTarget SiteUser user);
}
