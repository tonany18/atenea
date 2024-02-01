package com.demo.atenea.demo.controller;

import java.util.List;

import com.demo.atenea.demo.dto.SelectorDTO;
import com.demo.atenea.demo.service.AreaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/area")
@RequiredArgsConstructor
public class AreaController {
    private final Logger log = LoggerFactory.getLogger(AreaController.class);

    private final AreaService areaService;

    /**
     * Get all areas
     * 
     * @return areas
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SelectorDTO>> getAll() {
        log.info("GET request api/v1/area");
        var result = areaService.listAllAsSelectorDTO();
        return result.isEmpty() ? ResponseEntity.badRequest().build() : ResponseEntity.ok().body(result);
    }
}
