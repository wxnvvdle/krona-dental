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
import org.springframework.stereotype.Service;

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
        Ticket ticket = new Ticket();
        Technik technik = technikRepo.findById(createTicketDTO.getTechnikId()).orElseThrow();
        Dentist dentist = dentistRepo.findById(createTicketDTO.getDentistId()).orElseThrow();
        Manager manager = managerRepo.findById(createTicketDTO.getManagerId()).orElseThrow();

        ticket = ticketMapper.create(ticket, createTicketDTO, technik, dentist, manager);

        return ticketMapper.toDTO(ticketRepo.save(ticket));
    }

    @Override
    public TicketDTO update(Long id, UpdateTicketDTO updateTicketDTO) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow();
        Technik technik = technikRepo.findById(updateTicketDTO.getTechnikId()).orElseThrow();
        Dentist dentist = dentistRepo.findById(updateTicketDTO.getDentistId()).orElseThrow();
        Manager manager = managerRepo.findById(updateTicketDTO.getManagerId()).orElseThrow();

        ticket = ticketMapper.update(ticket, updateTicketDTO, technik, dentist, manager);


        return ticketMapper.toDTO(ticketRepo.save(ticket));
    }

    @Override
    public void delete(Long id) {
        Ticket ticket = ticketRepo.findById(id).orElseThrow();
        ticket.setActive(false);

        ticketRepo.save(ticket);
    }
}
