package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.dto.dentist.CreateDentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.UpdateDentistDTO;
import com.kronadental.kronadental.domain.mapper.DentistMapper;
import com.kronadental.kronadental.domain.mapper.DentistMapperList;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.DentistRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistMapper dentistMapper;

    @Autowired
    private DentistMapperList dentistMapperList;

    @Autowired
    private DentistRepo dentistRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public DentistDTO getById(Long id) {
        return dentistMapper.toDTO(dentistRepo.findDentistByIdAndActiveTrue(id));
    }

    @Override
    public List<DentistDTO> getAll() {
        return dentistMapperList.toDTOList(dentistRepo.findAllByActiveTrue());
    }

    @Override
    public DentistDTO create(CreateDentistDTO createDentistDTO) {
        Dentist dentist = dentistMapper.create(createDentistDTO);

        Company company = companyRepo.findCompanyByIdAndActiveTrue(createDentistDTO.getCompanyId());
        if(company != null) {
            dentist.setCompany(company);
        }
        if (createDentistDTO.getTicketIdList() != null) {
            dentist.setTicketList(ticketRepo.findAllByIdAndActiveTrue(createDentistDTO.getTicketIdList()));
        }

        return dentistMapper.toDTO(dentistRepo.save(dentist));
    }

    @Override
    public DentistDTO update(Long id, UpdateDentistDTO updateDentistDTO) {
        Dentist dentist = dentistRepo.findByIdAndActiveTrue(id);
        if(dentist == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Dentist with id=" + id + " not found");
        }
        dentist = dentistMapper.update(dentist, updateDentistDTO);
        Company company = companyRepo.findCompanyByIdAndActiveTrue(updateDentistDTO.getCompanyId());

        if(company != null) {
            dentist.setCompany(company);
        }

        if (updateDentistDTO.getTicketIdList() != null) {
            dentist.setTicketList(ticketRepo.findAllByIdAndActiveTrue(updateDentistDTO.getTicketIdList()));
        }

        return dentistMapper.toDTO(dentistRepo.save(dentist));
    }

    @Override
    public void delete(Long id) {
        Dentist dentist = dentistRepo.findById(id).orElseThrow();
        dentist.setActive(false);

        dentistRepo.save(dentist);
    }
}
