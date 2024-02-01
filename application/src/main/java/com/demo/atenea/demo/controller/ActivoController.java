package com.demo.atenea.demo.controller;

import java.util.List;

import javax.validation.Valid;

import com.demo.atenea.demo.dto.ActivoDTO;
import com.demo.atenea.demo.dto.ActivoSearchCriteriaDTO;
import com.demo.atenea.demo.dto.TransactionDTO;
import com.demo.atenea.demo.service.ActivoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/activo")
@RequiredArgsConstructor
public class ActivoController {

    private final Logger log = LoggerFactory.getLogger(ActivoController.class);

    private final ActivoService activoService;

    /**
     * Get all actives
     * 
     * @return actives
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActivoDTO>> getActives() {
        log.info("GET request api/v1/activo");
        return activoService.getAll()
                .map(dto -> ResponseEntity.ok().body(dto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get active by id
     * 
     * @return active
     */
    @GetMapping(path = "/{activoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActivoDTO> getActive(@PathVariable Long activoId) {
        log.info("GET request api/v1/activo/{activoId}", activoId);
        return activoService.get(activoId)
                .map(dto -> ResponseEntity.ok().body(dto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get actives search by criteria
     * 
     * @param criterios
     * @return
     */
    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActivoDTO>> getActives(ActivoSearchCriteriaDTO criterios) {
        log.info("GET request api/v1/activo");
        return activoService.findByCriterias(criterios)
                .map(dto -> ResponseEntity.ok().body(dto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create active
     * 
     * @param activo
     * @return
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDTO> save(@Valid @RequestBody ActivoDTO activo, BindingResult validation) {
        log.info("POST request api/v1/activo : {}", activo);
        var result = new TransactionDTO();
        try {
            result = activoService.save(activo, validation);
        } catch (Exception e) {
            log.error("POST request api/v1/activo, error: {}", e);
            return ResponseEntity.internalServerError().build();
        }
        return new ResponseEntity<TransactionDTO>(result,
                result.getEstado() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    /**
     * Update active
     * 
     * @param activo
     * @return
     */
    @PatchMapping(path = "/{activoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDTO> patch(@PathVariable Long activoId, @RequestBody ActivoDTO activo) {
        log.info("PATCH request api/v1/activo : {}", activo);
        var result = new TransactionDTO();
        try {
            result = activoService.patch(activoId, activo);
        } catch (Exception e) {
            log.error("PATCH request api/v1/activo, error: {}", e);
            return ResponseEntity.internalServerError().build();
        }
        return new ResponseEntity<TransactionDTO>(result,
                result.getEstado() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}