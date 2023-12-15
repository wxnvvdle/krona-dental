package com.kronadental.kronadental.domain.dto.technik;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.enums.Specialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechnikDTO {

    private Long id;

    private String name;

    private Specialization specialization;

    private CompanyDTO company;

    private List<TicketDTO> ticketDTOList;

}
