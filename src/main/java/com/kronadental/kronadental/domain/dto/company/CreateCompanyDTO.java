package com.kronadental.kronadental.domain.dto.company;

import com.kronadental.kronadental.domain.enums.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCompanyDTO {

    private CompanyType companyType;

    private String name;

    private String address;

    private List<Long> managerIdList;

    private List<Long> dentistIdList;

    private List<Long> technikIdList;

}
