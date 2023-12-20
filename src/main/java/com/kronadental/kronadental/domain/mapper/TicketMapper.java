package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.ticket.CreateTicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.UpdateTicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    public Ticket create(CreateTicketDTO createTicketDTO);

    @Mapping(target = "id", ignore = true)
    public Ticket update(Ticket ticket, UpdateTicketDTO updateTicketDTO);

    public TicketDTO toDTO(Ticket ticket);

}
