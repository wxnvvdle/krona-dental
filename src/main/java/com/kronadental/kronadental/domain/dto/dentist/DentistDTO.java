package com.kronadental.kronadental.domain.dto.dentist;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DentistDTO {

    private Long id;

    private String name;

    private CompanyDTO company;

    private List<TicketDTO> ticketList;

}
