package com.demo.atenea.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaDTO {
    private Long id;
    private String tipoDocumento;
    private String numDocumento;
    private String nombre;
    private String apellido;
}
