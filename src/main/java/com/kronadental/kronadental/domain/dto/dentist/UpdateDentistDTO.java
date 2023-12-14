package com.kronadental.kronadental.domain.dto.dentist;

import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UpdateDentistDTO {

    private String name;

    private Long companyId;

    private List<Long> ticketIdList;
}
