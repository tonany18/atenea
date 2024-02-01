package com.demo.atenea.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivoDTO {
    private Long id;
    @NotBlank
    private String nombre;
    private String descripcion;
    @NotBlank
    private String serial;
    @NotNull
    private Integer numInterno;
    private Double peso;
    private Double alto;
    private Double ancho;
    private Double largo;
    @NotNull
    private BigDecimal valorCompra;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaCompra;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaBaja;
    private String color;
    @NotNull
    private TipoActivoDTO tipo;
    @NotNull
    private EstadoActivoDTO estado;
    @NotNull
    private Boolean asignaArea;
    private AreaDTO area;
    private PersonaDTO persona;
}
