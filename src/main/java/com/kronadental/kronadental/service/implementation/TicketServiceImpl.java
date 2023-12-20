package com.kronadental.kronadental.service.implementation;

import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.ticket.CreateTicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.UpdateTicketDTO;
import com.kronadental.kronadental.domain.mapper.TicketMapper;
import com.kronadental.kronadental.repository.DentistRepo;
import com.kronadental.kronadental.repository.ManagerRepo;
import com.kronadental.kronadental.repository.TechnikRepo;
import com.kronadental.kronadental.repository.TicketRepo;
import com.kronadental.kronadental.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private TechnikRepo technikRepo;

    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private DentistRepo dentistRepo;


    @Override
    public TicketDTO getById(Long id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow();
        return ticketMapper.toDTO(ticket);
    }

    @Override
    public List<TicketDTO> getAll() {
        return null;
    }

    @Override
    public TicketDTO create(CreateTicketDTO createTicketDTO) {
        Ticket ticket = ticketMapper.create(createTicketDTO);

        Technik technik = technikRepo.findByIdAndActiveTrue(createTicketDTO.getTechnikId()).orElseThrow();
        if (technik != null) {
            ticket.setTechnik(technik);
        }

        Dentist dentist = dentistRepo.findByIdAndActiveTrue(createTicketDTO.getDentistId()).orElseThrow();
        if (dentist != null) {
            ticket.setDentist(dentist);
        }

        Manager manager = managerRepo.findByIdAndActiveTrue(createTicketDTO.getManagerId()).orElseThrow();
        if (manager != null) {
            ticket.setManager(manager);
        }

        return ticketMapper.toDTO(ticketRepo.save(ticket));
    }

    @Override
    public TicketDTO update(Long id, UpdateTicketDTO updateTicketDTO) {
        Ticket ticket = ticketRepo.findByIdAndActiveTrue(id).orElseThrow();
        if(ticket == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Ticket with id=" + id + " not found");
        }
        ticket = ticketMapper.update(ticket, updateTicketDTO);

        Technik technik = technikRepo.findByIdAndActiveTrue(updateTicketDTO.getTechnikId()).orElseThrow();
        if (technik != null) {
            ticket.setTechnik(technik);
        }

        Dentist dentist = dentistRepo.findByIdAndActiveTrue(updateTicketDTO.getDentistId()).orElseThrow();
        if (dentist != null) {
            ticket.setDentist(dentist);
        }

        Manager manager = managerRepo.findByIdAndActiveTrue(updateTicketDTO.getManagerId()).orElseThrow();
        if (manager != null) {
            ticket.setManager(manager);
        }

        return ticketMapper.toDTO(ticketRepo.save(ticket));
    }

    @Override
    public void delete(Long id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow();
        ticket.setActive(false);

        ticketRepo.save(ticket);
    }
}
