package com.demo.atenea.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AreaDTO {
    private Long id;
    private String sigla;
    private String nombre;
    private CiudadDTO ciudad;
}