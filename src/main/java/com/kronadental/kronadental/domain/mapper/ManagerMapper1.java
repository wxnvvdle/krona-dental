package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.manager.CreateManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.UpdateManagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerMapper1 {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private TicketMapper ticketMapper;

    public Manager create(Manager manager, CreateManagerDTO createManagerDTO, Company company, List<Ticket> ticketList) {
        manager.setName(createManagerDTO.getName());
        manager.setCompany(company);
        manager.setTicketList(ticketList);

        return manager;
    }

    public Manager update(Manager manager, UpdateManagerDTO updateManagerDTO, Company company, List<Ticket> ticketList) {
        manager.setName(updateManagerDTO.getName());
        manager.setCompany(company);
        manager.setTicketList(ticketList);

        return manager;
    }

    public ManagerDTO toDTO(Manager manager) {
        ManagerDTO managerDTO = new ManagerDTO();

        managerDTO.setId(manager.getId());
        managerDTO.setName(manager.getName());
        managerDTO.setCompany(companyMapper.toDTO(manager.getCompany()));
        managerDTO.setTicketDTOList(ticketMapper.toDTO(manager.getTicketList()));

        return managerDTO;
    }

    public List<ManagerDTO> toDTO(List<Manager> managerList) {
        List<ManagerDTO> managerDTOList = new ArrayList<>();

        managerList.forEach(manager -> managerDTOList.add(toDTO(manager)));

        return managerDTOList;
    }

}
