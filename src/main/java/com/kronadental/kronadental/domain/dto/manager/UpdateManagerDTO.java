package com.kronadental.kronadental.domain.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateManagerDTO {

    private String name;

    private Long companyId;

    private List<Long> ticketIdList;

}
