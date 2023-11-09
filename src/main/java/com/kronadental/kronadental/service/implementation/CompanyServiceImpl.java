package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.mapper.CompanyMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapper.toDTO(companyRepo.findAll());
    }

    @Override
    public CompanyDTO getById(Long id) {
        return companyMapper.toDTO(companyRepo.getById(id));
    }
}
