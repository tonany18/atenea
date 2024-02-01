package com.demo.atenea.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.demo.atenea.demo.dto.SelectorDTO;
import com.demo.atenea.demo.repository.AreaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AreaService {

    @Autowired
    private AreaRepository repository;

    public List<SelectorDTO> listAllAsSelectorDTO() {
        return repository.findAll().stream().map(e -> new SelectorDTO(e.getId(), e.getNombre()))
                .collect(Collectors.toList());
    }
}
