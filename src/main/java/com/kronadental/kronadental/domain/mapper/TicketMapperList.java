package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TicketMapper.class)
public interface TicketMapperList {

    public List<TicketDTO> toDTOList(List<Ticket> ticketList);

}
