package com.demo.atenea.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.demo.atenea.demo.dto.SelectorDTO;
import com.demo.atenea.demo.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {

    @Autowired
    private PersonaRepository repository;

    public List<SelectorDTO> listAllAsSelectorDTO() {
        return repository.findAll().stream().map(e -> new SelectorDTO(e.getId(), e.getNombre() + " " + e.getApellido()))
                .collect(Collectors.toList());
    }
}
