package com.kronadental.kronadental.service;

import com.kronadental.kronadental.domain.dto.ticket.CreateTicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.UpdateTicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    TicketDTO getById(Long id);

    List<TicketDTO> getAll();

    TicketDTO create(CreateTicketDTO createTicketDTO);

    TicketDTO update(Long id, UpdateTicketDTO updateTicketDTO);

    void delete(Long id);
}
