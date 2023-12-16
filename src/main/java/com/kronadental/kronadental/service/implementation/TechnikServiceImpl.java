package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.technik.CreateTechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.UpdateTechnikDTO;
import com.kronadental.kronadental.domain.mapper.TechnikMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.TechnikRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.TechnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnikServiceImpl implements TechnikService {

    @Autowired
    private TechnikRepo technikRepo;

    @Autowired
    private TechnikMapper technikMapper;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public TechnikDTO getById(Long id) {
        return technikMapper.toDTO(technikRepo.findById(id).orElseThrow());
    }

    @Override
    public List<TechnikDTO> getAll() {
        return technikMapper.toDTO(technikRepo.findAll());
    }

    @Override
    public TechnikDTO create(CreateTechnikDTO createTechnikDTO) {
        Technik technik = new Technik();
         Company company = companyRepo.findById(createTechnikDTO.getCompanyId()).orElseThrow();
        List<Ticket> ticketList = new ArrayList<>();

        if (createTechnikDTO.getTicketIdList() != null) {
            ticketList = ticketRepo.findAllById(createTechnikDTO.getTicketIdList());
        }
        technik = technikMapper.create(technik, createTechnikDTO, company, ticketList);

        return technikMapper.toDTO(technikRepo.save(technik));
    }

    @Override
    public TechnikDTO update(Long id, UpdateTechnikDTO updateTechnikDTO) {
        Technik technik = technikRepo.findById(id).orElseThrow();
        Company company = companyRepo.findById(updateTechnikDTO.getCompanyId()).orElseThrow();
        List<Ticket> ticketList = ticketRepo.findAllById(updateTechnikDTO.getTicketIdList());

        technik = technikMapper.update(technik, updateTechnikDTO, company, ticketList);

        return technikMapper.toDTO(technikRepo.save(technik));
    }

    @Override
    public void delete(Long id) {
        Technik technik = technikRepo.findById(id).orElseThrow();
        technik.setActive(false);

        technikRepo.save(technik);
    }
}
