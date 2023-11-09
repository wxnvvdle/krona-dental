package com.kronadental.kronadental.domain.dto.manager;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Ticket;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ManagerDTO {

    private Long id;

    private String name;

    private CompanyDTO company;

    private List<TicketDTO> ticketDTOList;

}
