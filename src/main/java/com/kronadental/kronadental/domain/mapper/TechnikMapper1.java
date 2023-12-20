package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.technik.CreateTechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.UpdateTechnikDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TechnikMapper1 {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private TicketMapper ticketMapper;

    public Technik create(Technik technik, CreateTechnikDTO createTechnikDTO, Company company, List<Ticket> ticketList) {
        technik.setName(createTechnikDTO.getName());
        technik.setSpecialization(createTechnikDTO.getSpecialization());
        technik.setCompany(company);
        technik.setTicketList(ticketList);

        return technik;
    }

    public Technik update(Technik technik, UpdateTechnikDTO updateTechnikDTO, Company company, List<Ticket> ticketList) {
        technik.setName(updateTechnikDTO.getName());
        technik.setSpecialization(updateTechnikDTO.getSpecialization());
        technik.setCompany(company);
        technik.setTicketList(ticketList);

        return technik;
    }

    public TechnikDTO toDTO(Technik technik) {
        TechnikDTO technikDTO = new TechnikDTO();

        technikDTO.setId(technik.getId());
        technikDTO.setName(technik.getName());
        technikDTO.setCompany(companyMapper.toDTO(technik.getCompany()));
        technikDTO.setTicketDTOList(ticketMapper.toDTO(technik.getTicketList()));

        return technikDTO;
    }

    public List<TechnikDTO> toDTO(List<Technik> technikList) {
        List<TechnikDTO> technikDTOList = new ArrayList<>();

        technikList.forEach(technik -> technikDTOList.add(toDTO(technik)));

        return technikDTOList;
    }
}
