package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.technik.CreateTechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.UpdateTechnikDTO;
import com.kronadental.kronadental.domain.mapper.TechnikMapper;
import com.kronadental.kronadental.repository.CompanyRepo;
import com.kronadental.kronadental.repository.TechnikRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.TechnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return technikMapper.toDTO(technikRepo.findByIdAndActiveTrue(id));
    }

    @Override
    public List<TechnikDTO> getAll() {
        return technikMapper.toDTO(technikRepo.findAllByActiveTrue());
    }

    @Override
    public TechnikDTO create(CreateTechnikDTO createTechnikDTO) {
        Technik technik = new Technik();
        Company company = companyRepo.findCompanyByIdAndActiveTrue(createTechnikDTO.getCompanyId());
        if(company != null) {
            technik.setCompany(company);
        }
        if (createTechnikDTO.getTicketIdList() != null) {
            technik.setTicketList(ticketRepo.findAllByIdAndActiveTrue(createTechnikDTO.getTicketIdList()));
        }
        return technikMapper.toDTO(technikRepo.save(technik));
    }

    @Override
    public TechnikDTO update(Long id, UpdateTechnikDTO updateTechnikDTO) {
        Technik technik = technikRepo.findByIdAndActiveTrue(id);
        if(technik == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Technik with id=" + id + " not found");
        }
        technik = technikMapper.update(technik, updateTechnikDTO);
        Company company = companyRepo.findCompanyByIdAndActiveTrue(updateTechnikDTO.getCompanyId());

        if(company != null) {
            technik.setCompany(company);
        }

        if (updateTechnikDTO.getTicketIdList() != null) {
            technik.setTicketList(ticketRepo.findAllByIdAndActiveTrue(updateTechnikDTO.getTicketIdList()));
        }

        return technikMapper.toDTO(technikRepo.save(technik));
    }

    @Override
    public void delete(Long id) {
        Technik technik = technikRepo.findById(id).orElseThrow();
        technik.setActive(false);

        technikRepo.save(technik);
    }
}
