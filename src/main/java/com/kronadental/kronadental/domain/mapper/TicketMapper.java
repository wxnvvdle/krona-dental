package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.ticket.CreateTicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.UpdateTicketDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapper {

    public Ticket create(Ticket ticket, CreateTicketDTO createTicketDTO, Technik technik, Dentist dentist, Manager manager) {
        ticket.setStatus(createTicketDTO.getStatus());
        ticket.setPreparingStage(createTicketDTO.getPreparingStage());
        ticket.setLastStage(createTicketDTO.getLastStage());
        ticket.setTechnik(technik);
        ticket.setDentist(dentist);
        ticket.setManager(manager);

        return ticket;
    }

    public Ticket update(Ticket ticket, UpdateTicketDTO updateTicketDTO, Technik technik, Dentist dentist, Manager manager) {
        ticket.setStatus(updateTicketDTO.getStatus());
        ticket.setPreparingStage(updateTicketDTO.getPreparingStage());
        ticket.setLastStage(updateTicketDTO.getLastStage());
        ticket.setTechnik(technik);
        ticket.setDentist(dentist);
        ticket.setManager(manager);

        return ticket;
    }

    public TicketDTO toDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(ticket.getId());
        ticketDTO.setStatus(ticket.getStatus());
        ticketDTO.setPreparingStage(ticket.getPreparingStage());
        ticketDTO.setLastStage(ticket.getLastStage());
        ticketDTO.setTechnikId(ticket.getTechnik().getId());
        ticketDTO.setDentistId(ticket.getDentist().getId());
        ticketDTO.setManagerId(ticket.getManager().getId());

        return ticketDTO;
    }

    public List<TicketDTO> toDTO(List<Ticket> ticketList) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        ticketList.forEach(ticket -> ticketDTOList.add(toDTO(ticket)));

        return ticketDTOList;
    }


}
