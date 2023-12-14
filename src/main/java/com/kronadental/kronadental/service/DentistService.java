package com.kronadental.kronadental.service;

import com.kronadental.kronadental.domain.dto.dentist.CreateDentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.UpdateDentistDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DentistService {

    DentistDTO getById(Long id);

    List<DentistDTO> getAll();

    DentistDTO create(CreateDentistDTO createDentistDTO);

    DentistDTO update(Long id, UpdateDentistDTO updateDentistDTO);

    void delete(Long id);
}
