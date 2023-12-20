package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.dto.manager.CreateManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.UpdateManagerDTO;
import com.kronadental.kronadental.domain.mapper.ManagerMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.ManagerRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return managerMapper.toDTO(managerRepo.findByIdAndActiveTrue(id));
    }

    @Override
    public List<ManagerDTO> getAll() {
        return managerMapper.toDTO(managerRepo.findAllByActiveTrue());
    }

    @Override
    public ManagerDTO create(CreateManagerDTO createManagerDTO) {
        Manager manager = managerMapper.create(createManagerDTO);

        if (createManagerDTO.getCompanyId() != null) {
            manager.setCompany(companyRepo.findCompanyByIdAndActiveTrue(createManagerDTO.getCompanyId()));
        }

        if (createManagerDTO.getTicketIdList() != null) {
            manager.setTicketList(ticketRepo.findAllByIdAndActiveTrue(createManagerDTO.getTicketIdList()));
        }

        return managerMapper.toDTO(managerRepo.save(manager));
    }

    @Override
    public ManagerDTO update(Long id, UpdateManagerDTO updateManagerDTO) {
        //TODO check orElseThrow Exception
        Manager manager = managerRepo.findByIdAndActiveTrue(id);
        if(manager == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Manager with id=" + id + " not found");
        }
        manager = managerMapper.update(manager, updateManagerDTO);
        Company company = companyRepo.findCompanyByIdAndActiveTrue(updateManagerDTO.getCompanyId());

        if(company != null) {
            manager.setCompany(company);
        }

        if (updateManagerDTO.getTicketIdList() != null) {
            manager.setTicketList(ticketRepo.findAllByIdAndActiveTrue(updateManagerDTO.getTicketIdList()));
        }

        return managerMapper.toDTO(managerRepo.save(manager));
    }

    @Override
    public void delete(Long id) {
        Manager manager = managerRepo.findById(id).orElseThrow();
        manager.setActive(false);

        managerRepo.save(manager);
    }
}
