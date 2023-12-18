package com.kronadental.kronadental.domain.dto.company;

import com.kronadental.kronadental.domain.enums.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateCompanyDTO {

    private Boolean active;

    private CompanyType companyType;

    private String name;

    private String address;

}
