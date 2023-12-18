package com.kronadental.kronadental.service;

import com.kronadental.kronadental.domain.dto.technik.CreateTechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.UpdateTechnikDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnikService {

    TechnikDTO getById(Long id);

    List<TechnikDTO> getAll();

    TechnikDTO create(CreateTechnikDTO createTechnikDTO);

    TechnikDTO update(Long id, UpdateTechnikDTO updateTechnikDTO);

    void delete(Long id);
}
