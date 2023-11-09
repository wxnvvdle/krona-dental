package com.kronadental.kronadental.controller;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    public List<CompanyDTO> getAll(){
        return companyService.findAll();
    }

    public CompanyDTO getCompany(Long id){
        return companyService.getById(id);
    }

}
