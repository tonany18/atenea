package com.demo.atenea.demo.mapper;

import com.demo.atenea.demo.domain.TipoActivo;
import com.demo.atenea.demo.dto.TipoActivoDTO;

public class TipoActivoMapper {

    public static TipoActivo fromId(Long id) {
        if (id == null) {
            return null;
        }
        TipoActivo entity = new TipoActivo();
        entity.setId(id);
        return entity;
    }

    public static TipoActivo toEntity(TipoActivoDTO dto) {
        if (dto == null) {
            return null;
        }

        TipoActivo entity = new TipoActivo();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        entity.setNombre(dto.getNombre());
        return entity;
    }

    public static TipoActivoDTO toDTO(TipoActivo entity) {
        TipoActivoDTO dto = new TipoActivoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
