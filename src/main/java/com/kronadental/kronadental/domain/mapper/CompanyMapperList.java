package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface CompanyMapperList {
    List<CompanyDTO> toDTOList(List<Company> modelList);
}
