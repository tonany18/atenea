package com.demo.atenea.demo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activo")
@Data
@NoArgsConstructor
public class Activo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String serial;
    private Integer numInterno;
    private Double peso;
    private Double alto;
    private Double ancho;
    private Double largo;
    private BigDecimal valorCompra;
    private LocalDate fechaCompra;
    private LocalDate fechaBaja;
    private String color;

    @ManyToOne
    private TipoActivo tipoActivo;

    @ManyToOne
    private EstadoActivo estadoActivo;

    private Boolean asignaArea;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Persona persona;
}
