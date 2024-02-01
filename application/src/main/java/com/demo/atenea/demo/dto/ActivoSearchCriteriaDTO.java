package com.demo.atenea.demo.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivoSearchCriteriaDTO {
    private String tipo;
    private String serial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCompra;
}
