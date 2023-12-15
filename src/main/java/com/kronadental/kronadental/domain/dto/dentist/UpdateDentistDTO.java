package com.kronadental.kronadental.domain.dto.dentist;

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
