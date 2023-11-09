package com.kronadental.kronadental.service;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

   List<CompanyDTO> findAll();

   CompanyDTO getById(Long id);

}


