package com.demo.atenea.demo.controller;

import java.util.List;

import com.demo.atenea.demo.dto.SelectorDTO;
import com.demo.atenea.demo.service.PersonaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final Logger log = LoggerFactory.getLogger(PersonaController.class);

    private final PersonaService personaService;

    /**
     * Get all people
     * 
     * @return people
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SelectorDTO>> getAll() {
        log.info("GET request api/v1/persona");
        var result = personaService.listAllAsSelectorDTO();
        return result.isEmpty() ? ResponseEntity.badRequest().build() : ResponseEntity.ok().body(result);
    }
}
