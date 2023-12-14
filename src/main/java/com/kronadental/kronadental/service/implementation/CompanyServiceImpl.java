package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.company.CreateCompanyDTO;
import com.kronadental.kronadental.domain.dto.company.UpdateCompanyDTO;
import com.kronadental.kronadental.domain.mapper.CompanyMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.DentistRepo;
import com.kronadental.kronadental.repository.ManagerRepo;
import com.kronadental.kronadental.repository.TechnikRepo;
import com.kronadental.kronadental.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private DentistRepo dentistRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private TechnikRepo technikRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapper.toDTO(companyRepo.findAllByActiveTrue());
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
        Company company = new Company();
        List<Dentist> dentistList = new ArrayList<>();
        List<Manager> managerList = new ArrayList<>();
        List<Technik> technikList = new ArrayList<>();

        if (createCompanyDTO.getDentistIdList() != null) {
            dentistList = dentistRepo.findAllById(createCompanyDTO.getDentistIdList());
        }

        if (createCompanyDTO.getManagerIdList() != null) {
            managerList = managerRepo.findAllById(createCompanyDTO.getManagerIdList());
        }

        if (createCompanyDTO.getTechnikIdList() != null) {
            technikList = technikRepo.findAllById(createCompanyDTO.getTechnikIdList());
        }

        companyRepo.save(companyMapper.create(company, createCompanyDTO, dentistList, managerList, technikList));
        return companyMapper.toDTO(company);
    }

    @Override
    public CompanyDTO update(Long id, UpdateCompanyDTO updateCompanyDTO) {
        Company company = companyRepo.findById(id).orElseThrow();
        List<Dentist> dentistList = new ArrayList<>();
        List<Manager> managerList = new ArrayList<>();
        List<Technik> technikList = new ArrayList<>();

        if (updateCompanyDTO.getDentistIdList() != null) {
            dentistList = dentistRepo.findAllById(updateCompanyDTO.getDentistIdList());
        }

        if (updateCompanyDTO.getManagerIdList() != null) {
            managerList = managerRepo.findAllById(updateCompanyDTO.getManagerIdList());
        }

        if (updateCompanyDTO.getTechnikIdList() != null) {
            technikList = technikRepo.findAllById(updateCompanyDTO.getTechnikIdList());
        }

        companyMapper.update(company, updateCompanyDTO, dentistList, managerList, technikList);

        return companyMapper.toDTO(companyRepo.save(company));
    }

    @Override
    public void delete(Long id) {
        Company company = companyRepo.findById(id).orElseThrow();
        company.setActive(false);

        companyRepo.save(company);
    }
}
