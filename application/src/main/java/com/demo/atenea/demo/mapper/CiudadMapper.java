package com.demo.atenea.demo.mapper;

import com.demo.atenea.demo.domain.Ciudad;
import com.demo.atenea.demo.dto.CiudadDTO;

public class CiudadMapper {

    public static Ciudad fromId(Long id) {
        if (id == null) {
            return null;
        }
        Ciudad entity = new Ciudad();
        entity.setId(id);
        return entity;
    }
    
    public static Ciudad toEntity(CiudadDTO dto) {
        if (dto == null) {
            return null;
        }

        Ciudad entity = new Ciudad();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        entity.setCodigo(dto.getCodigo());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public static CiudadDTO toDTO(Ciudad entity) {
        CiudadDTO dto = new CiudadDTO();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
