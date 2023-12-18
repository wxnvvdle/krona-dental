package com.kronadental.kronadental.domain.dto.technik;

import com.kronadental.kronadental.domain.enums.Specialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTechnikDTO {

    private String name;

    private Specialization specialization;

    private Long companyId;

    private List<Long> ticketIdList;

}
