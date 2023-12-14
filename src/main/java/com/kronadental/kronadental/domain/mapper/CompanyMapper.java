package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.company.CreateCompanyDTO;
import com.kronadental.kronadental.domain.dto.company.UpdateCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyMapper {

    public Company create(Company company, CreateCompanyDTO createCompanyDTO, List<Dentist> dentistList, List<Manager> managerList, List<Technik> technikList) {
        company.setCompanyType(createCompanyDTO.getCompanyType());
        company.setName(createCompanyDTO.getName());
        company.setAddress(createCompanyDTO.getAddress());
        company.setDentistList(dentistList);
        company.setManagerList(managerList);
        company.setTechnikList(technikList);
        return company;
    }

    public Company update(Company company, UpdateCompanyDTO companyDTO, List<Dentist> dentistList, List<Manager> managerList, List<Technik> technikList) {
        company.setCompanyType(companyDTO.getCompanyType());
        company.setName(companyDTO.getName());
        company.setAddress(companyDTO.getAddress());
        if (!dentistList.isEmpty()) {
            company.setDentistList(dentistList);
        }
        if (!managerList.isEmpty()) {
            company.setManagerList(managerList);
        }
        if (!technikList.isEmpty()) {
            company.setTechnikList(technikList);
        }
        return company;
    }

    public CompanyDTO toDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();

        List<Long> managerIdList = company.getManagerList().stream()
                .map(Manager::getId)
                .collect(Collectors.toList());
        List<Long> dentistIdList = company.getDentistList().stream()
                .map(Dentist::getId)
                .collect(Collectors.toList());
        List<Long> technikIdList = company.getTechnikList().stream()
                .map(Technik::getId)
                .toList();

        companyDTO.setId(company.getId());
        companyDTO.setCompanyType(company.getCompanyType());
        companyDTO.setName(company.getName());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setManagerIdList(managerIdList);
        companyDTO.setDentistIdList(dentistIdList);
        companyDTO.setTechnikIdList(technikIdList);

        return companyDTO;
    }

    public List<CompanyDTO> toDTO(List<Company> companyList) {
        List<CompanyDTO> companyDTOList = new ArrayList<>();

        companyList.forEach(company -> companyDTOList.add(toDTO(company)));

        return companyDTOList;
    }

}
