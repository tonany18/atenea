package com.demo.atenea.demo.mapper;

import com.demo.atenea.demo.domain.EstadoActivo;
import com.demo.atenea.demo.dto.EstadoActivoDTO;

public class EstadoActivoMapper {

    public static EstadoActivo fromId(Long id) {
        if (id == null) {
            return null;
        }
        EstadoActivo entity = new EstadoActivo();
        entity.setId(id);
        return entity;
    }

    public static EstadoActivo toEntity(EstadoActivoDTO dto) {
        if (dto == null) {
            return null;
        }

        EstadoActivo entity = new EstadoActivo();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        entity.setNombre(dto.getNombre());
        return entity;
    }

    public static EstadoActivoDTO toDTO(EstadoActivo entity) {
        EstadoActivoDTO dto = new EstadoActivoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }
}
