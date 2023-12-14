package com.kronadental.kronadental.service;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.company.CreateCompanyDTO;
import com.kronadental.kronadental.domain.dto.company.UpdateCompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

   List<CompanyDTO> findAll();

   CompanyDTO getById(Long id);

   CompanyDTO create(CreateCompanyDTO createCompanyDTO);

   CompanyDTO update(Long id, UpdateCompanyDTO updateCompanyDTO);

   void delete(Long id);

}


