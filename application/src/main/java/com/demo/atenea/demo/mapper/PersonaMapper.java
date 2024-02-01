package com.demo.atenea.demo.mapper;

import com.demo.atenea.demo.domain.Persona;
import com.demo.atenea.demo.dto.PersonaDTO;

public class PersonaMapper {

    public static Persona fromId(Long id) {
        if (id == null) {
            return null;
        }
        Persona entity = new Persona();
        entity.setId(id);
        return entity;
    }

    public static Persona toEntity(PersonaDTO dto) {
        if (dto == null) {
            return null;
        }

        Persona entity = new Persona();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setNumDocumento(dto.getNumDocumento());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        return entity;
    }

    public static PersonaDTO toDTO(Persona entity) {
        PersonaDTO dto = new PersonaDTO();
        dto.setId(entity.getId());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setNumDocumento(entity.getNumDocumento());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        return dto;
    }
}
