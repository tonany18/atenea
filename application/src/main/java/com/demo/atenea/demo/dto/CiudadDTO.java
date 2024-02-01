package com.demo.atenea.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CiudadDTO {
    private Long id;
    private String codigo;
    private String nombre;
}