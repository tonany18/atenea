package com.demo.atenea.demo.mapper;

import com.demo.atenea.demo.domain.Area;
import com.demo.atenea.demo.dto.AreaDTO;

public class AreaMapper {

    public static Area fromId(Long id) {
        if (id == null) {
            return null;
        }
        Area entity = new Area();
        entity.setId(id);
        return entity;
    }

    public static Area toEntity(AreaDTO dto) {
        if (dto == null) {
            return null;
        }

        Area entity = new Area();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        entity.setNombre(dto.getNombre());
        entity.setSigla(dto.getSigla());
        if (dto.getCiudad() != null) {
            entity.setCiudad(CiudadMapper.toEntity(dto.getCiudad()));
        }
        return entity;
    }

    public static AreaDTO toDTO(Area entity) {
        AreaDTO dto = new AreaDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setSigla(entity.getSigla());

        if (entity.getCiudad() != null) {
            dto.setCiudad(CiudadMapper.toDTO(entity.getCiudad()));
        }
        return dto;
    }
}
