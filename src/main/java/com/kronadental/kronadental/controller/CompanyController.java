package com.kronadental.kronadental.controller;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.company.CreateCompanyDTO;
import com.kronadental.kronadental.domain.dto.company.UpdateCompanyDTO;
import com.kronadental.kronadental.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public CompanyDTO get(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @GetMapping("/all")
    public List<CompanyDTO> getAll() {
        return companyService.findAll();
    }

    @PostMapping
    public CompanyDTO create(@RequestBody CreateCompanyDTO createCompanyDTO) {
        return companyService.create(createCompanyDTO);
    }

    @PutMapping("/{id}")
    public CompanyDTO update(@PathVariable Long id, @RequestBody UpdateCompanyDTO updateCompanyDTO) {
        return companyService.update(id, updateCompanyDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }

}
