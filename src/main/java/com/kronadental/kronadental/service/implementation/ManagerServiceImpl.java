package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.manager.CreateManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.UpdateManagerDTO;
import com.kronadental.kronadental.domain.mapper.ManagerMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.ManagerRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public ManagerDTO getById(Long id) {
        return managerMapper.toDTO(managerRepo.getById(id));
    }

    @Override
    public List<ManagerDTO> getAll() {
        return managerMapper.toDTO(managerRepo.findAll());
    }

    @Override
    public ManagerDTO create(CreateManagerDTO createManagerDTO) {
        Manager manager = new Manager();
        Company company = companyRepo.findById(createManagerDTO.getCompanyId()).orElseThrow();
        List<Ticket> ticketList = new ArrayList<>();

        if (createManagerDTO.getTicketIdList() != null) {
            ticketList = ticketRepo.findAllById(createManagerDTO.getTicketIdList());
        }

        manager = managerMapper.create(manager, createManagerDTO, company, ticketList);

        return managerMapper.toDTO(managerRepo.save(manager));
    }

    @Override
    public ManagerDTO update(Long id, UpdateManagerDTO updateManagerDTO) {
        //TODO check orElseThrow Exception
        Manager manager = managerRepo.findById(id).orElseThrow();
        Company company = companyRepo.findById(updateManagerDTO.getCompanyId()).orElseThrow();
        List<Ticket> ticketList = new ArrayList<>();

        if (updateManagerDTO.getTicketIdList() != null) {
            ticketList = ticketRepo.findAllById(updateManagerDTO.getTicketIdList());
        }

        manager = managerMapper.update(manager, updateManagerDTO, company, ticketList);

        return managerMapper.toDTO(managerRepo.save(manager));
    }

    @Override
    public void delete(Long id) {
        managerRepo.deleteById(id);
    }
}
