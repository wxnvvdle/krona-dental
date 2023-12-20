package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.company.CreateCompanyDTO;
import com.kronadental.kronadental.domain.dto.company.UpdateCompanyDTO;
import com.kronadental.kronadental.domain.mapper.CompanyMapper;
import com.kronadental.kronadental.domain.mapper.CompanyMapperList;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyMapperList companyMapperList;

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapperList.toDTOList(companyRepo.findAllByActiveTrue());
    }

    @Override
    public CompanyDTO getById(Long id) {
        Company company = companyRepo.findCompanyByIdAndActiveTrue(id);
        if (company == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Company with id=" + id + " not found");
        }

        return companyMapper.toDTO(company);
    }

    @Override
    public CompanyDTO create(CreateCompanyDTO createCompanyDTO) {
        return companyMapper.toDTO(companyRepo.save(companyMapper.create(createCompanyDTO)));
    }

    @Override
    public CompanyDTO update(Long id, UpdateCompanyDTO updateCompanyDTO) {
        Company company = companyRepo.findById(id).orElseThrow();
        return companyMapper.toDTO(companyRepo.save(companyMapper.update(company, updateCompanyDTO)));
    }

    @Override
    public void delete(Long id) {
        Company company = companyRepo.findById(id).orElseThrow();
        company.setActive(false);

        companyRepo.save(company);
    }
}
