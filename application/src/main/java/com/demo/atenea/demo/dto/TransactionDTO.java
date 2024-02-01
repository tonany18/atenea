package com.demo.atenea.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDTO {
    public TransactionDTO(String mensaje) {
        this.mensaje =  mensaje;
    } 
    
    public TransactionDTO(Boolean estado, String mensaje) {
        this.estado = estado;
        this.mensaje =  mensaje;
    } 

    private Boolean estado = false;
    private String mensaje;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}