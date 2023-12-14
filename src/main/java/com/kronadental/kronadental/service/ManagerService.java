package com.kronadental.kronadental.service;

import com.kronadental.kronadental.domain.dto.manager.CreateManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.UpdateManagerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ManagerService {

    ManagerDTO getById(Long id);

    List<ManagerDTO> getAll();

    ManagerDTO create(CreateManagerDTO createManagerDTO);

    ManagerDTO update(Long id, UpdateManagerDTO updateManagerDTO);

    void delete(Long id);
}
