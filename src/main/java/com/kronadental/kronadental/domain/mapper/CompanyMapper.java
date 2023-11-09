package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private DentistMapper dentistMapper;

    @Autowired
    private TechnikMapper technikMapper;

    public CompanyDTO toDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setId(companyDTO.getId());
        companyDTO.setCompanyType(company.getCompanyType());
        companyDTO.setName(companyDTO.getName());
        companyDTO.setAddress(companyDTO.getAddress());
        companyDTO.setManagerDTOList(managerMapper.toDTO(company.getManagerList()));
        companyDTO.setDentistDTOList(dentistMapper.toDTO(company.getDentistList()));
        companyDTO.setTechnikDTOList(technikMapper.toDTO(company.getTechnikList()));

        return companyDTO;
    }

    public List<CompanyDTO> toDTO(List<Company> companyList) {
        List<CompanyDTO> companyDTOList = new ArrayList<>();

        companyList.forEach(company -> companyDTOList.add(toDTO(company)));

        return companyDTOList;
    }

}
