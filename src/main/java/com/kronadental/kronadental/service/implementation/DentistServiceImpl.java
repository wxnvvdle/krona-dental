package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.dentist.CreateDentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.UpdateDentistDTO;
import com.kronadental.kronadental.domain.mapper.DentistMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.DentistRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistMapper dentistMapper;

    @Autowired
    private DentistRepo dentistRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public DentistDTO getById(Long id) {
        return dentistMapper.toDTO(dentistRepo.getById(id));
    }

    @Override
    public List<DentistDTO> getAll() {
        return dentistMapper.toDTO(dentistRepo.findAll());
    }

    @Override
    public DentistDTO create(CreateDentistDTO createDentistDTO) {
        Dentist dentist = new Dentist();
        Company company = companyRepo.findById(createDentistDTO.getCompanyId()).orElseThrow();
        List<Ticket> ticketList = new ArrayList<>();

        if (createDentistDTO.getTicketIdList() != null ) {
            ticketList = ticketRepo.findAllById(createDentistDTO.getTicketIdList());
        }
        dentist = dentistMapper.create(dentist, createDentistDTO, company, ticketList);

        return dentistMapper.toDTO(dentistRepo.save(dentist));
    }

    @Override
    public DentistDTO update(Long id, UpdateDentistDTO updateDentistDTO) {
        Dentist dentistToUpdate = dentistRepo.findById(id).orElseThrow();
        Company company = companyRepo.findById(updateDentistDTO.getCompanyId()).orElseThrow();
        List<Ticket> ticketList = new ArrayList<>();

        if (updateDentistDTO.getTicketIdList() != null ) {
            ticketList = ticketRepo.findAllById(updateDentistDTO.getTicketIdList());
        }

        dentistToUpdate = dentistMapper.update(dentistToUpdate, updateDentistDTO, company, ticketList);

        return dentistMapper.toDTO(dentistRepo.save(dentistToUpdate));
    }

    @Override
    public void delete(Long id) {
        dentistRepo.deleteById(id);
    }
}
