package com.demo.atenea.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.atenea.demo.domain.Activo;
import com.demo.atenea.demo.dto.ActivoDTO;

public class ActivoMapper {

    public static Activo fromId(Long id) {
        if (id == null) {
            return null;
        }
        Activo entity = new Activo();
        entity.setId(id);
        return entity;
    }

    public static Activo toEntity(ActivoDTO dto) {
        if (dto == null) {
            return null;
        }

        Activo entity = new Activo();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        entity.setAlto(dto.getAlto());
        entity.setAncho(dto.getAncho());
        entity.setColor(dto.getColor());
        entity.setDescripcion(dto.getDescripcion());
        entity.setFechaCompra(dto.getFechaCompra());
        entity.setFechaBaja(dto.getFechaBaja());
        entity.setLargo(dto.getLargo());
        entity.setNombre(dto.getNombre());
        entity.setSerial(dto.getSerial());
        entity.setValorCompra(dto.getValorCompra());
        entity.setNumInterno(dto.getNumInterno());
        entity.setAsignaArea(dto.getAsignaArea());
        entity.setEstadoActivo(EstadoActivoMapper.toEntity(dto.getEstado()));
        entity.setTipoActivo(TipoActivoMapper.toEntity(dto.getTipo()));
        entity.setPersona(PersonaMapper.toEntity(dto.getPersona()));
        entity.setArea(AreaMapper.toEntity(dto.getArea()));

        return entity;
    }

    public static ActivoDTO toDTO(Activo entity) {
        ActivoDTO dto = new ActivoDTO();
        dto.setId(entity.getId());
        dto.setAlto(entity.getAlto());
        dto.setAncho(entity.getAncho());
        dto.setColor(entity.getColor());
        dto.setDescripcion(entity.getDescripcion());
        dto.setFechaCompra(entity.getFechaCompra());
        dto.setFechaBaja(entity.getFechaBaja());
        dto.setLargo(entity.getLargo());
        dto.setSerial(entity.getSerial());
        dto.setNombre(entity.getNombre());
        dto.setNumInterno(entity.getNumInterno());
        dto.setValorCompra(entity.getValorCompra());
        dto.setAsignaArea(entity.getAsignaArea());

        if (entity.getEstadoActivo() != null) {
            dto.setEstado(EstadoActivoMapper.toDTO(entity.getEstadoActivo()));
        }
        if (entity.getTipoActivo() != null) {
            dto.setTipo(TipoActivoMapper.toDTO(entity.getTipoActivo()));
        }
        if (entity.getPersona() != null) {
            dto.setPersona(PersonaMapper.toDTO(entity.getPersona()));
        }
        if (entity.getArea() != null) {
            dto.setArea(AreaMapper.toDTO(entity.getArea()));
        }
        return dto;
    }

    public static List<ActivoDTO> toDTO(List<Activo> dtos) {
        return dtos.stream().map(dto -> ActivoMapper.toDTO(dto)).collect(Collectors.toList());
    }
}