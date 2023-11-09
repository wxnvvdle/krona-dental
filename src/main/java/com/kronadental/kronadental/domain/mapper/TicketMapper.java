package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.enums.LastStage;
import com.kronadental.kronadental.domain.enums.PreparingStage;
import com.kronadental.kronadental.domain.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapper {

    @Autowired
    private TechnikMapper technikMapper;

    @Autowired
    private DentistMapper dentistMapper;

    @Autowired
    private ManagerMapper managerMapper;

    public TicketDTO toDTO(Ticket ticket, Status status, PreparingStage preparingStage, LastStage lastStage) {
        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(ticket.getId());
        ticketDTO.setStatus(status);
        ticketDTO.setPreparingStage(preparingStage);
        ticketDTO.setLastStage(lastStage);
        ticketDTO.setTechnik(technikMapper.toDTO(ticket.getTechnik()));
        ticketDTO.setDentist(dentistMapper.toDTO(ticket.getDentist()));
        ticketDTO.setManager(managerMapper.toDTO(ticket.getManager()));

        return ticketDTO;
    }

    List<TicketDTO> toDTO(List<Ticket> ticketList) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        ticketList.forEach(ticket -> ticketDTOList.add(toDTO(ticket,
                ticket.getStatus(),
                ticket.getPreparingStage(),
                ticket.getLastStage())));

        return ticketDTOList;
    }

}
