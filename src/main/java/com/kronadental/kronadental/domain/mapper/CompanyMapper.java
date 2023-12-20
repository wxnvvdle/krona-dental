package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Company;
import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.company.CompanyDTO;
import com.kronadental.kronadental.domain.dto.company.CreateCompanyDTO;
import com.kronadental.kronadental.domain.dto.company.UpdateCompanyDTO;
import com.kronadental.kronadental.repository.ManagerRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = ManagerRepo.class)
public interface CompanyMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "managerList", ignore = true)
    @Mapping(target = "dentistList", ignore = true)
    @Mapping(target = "technikList", ignore = true)
    Company create(CreateCompanyDTO createCompanyDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "managerList", ignore = true)
    @Mapping(target = "dentistList", ignore = true)
    @Mapping(target = "technikList", ignore = true)
    Company update( @MappingTarget Company company, UpdateCompanyDTO updateCompanyDTO);

    @Mapping(target = "managerIdList", source = "managerList", qualifiedByName = "mapToManagerIdList")
    @Mapping(target = "dentistIdList", source = "dentistList", qualifiedByName = "mapToDentistIdList")
    @Mapping(target = "technikIdList", source = "technikList", qualifiedByName = "mapToTechnikIdList")
    CompanyDTO toDTO(Company company);

    @Named("mapToManagerIdList")
    default List<Long> mapToManagerList(List<Manager> managerList) {
        return managerList.stream()
                .map(Manager::getId)
                .collect(Collectors.toList());
    }

    @Named("mapToDentistIdList")
    default List<Long> mapToDentistIdList(List<Dentist> dentisList) {
        return dentisList.stream()
                .map(Dentist::getId)
                .collect(Collectors.toList());
    }

    @Named("mapToTechnikIdList")
    default List<Long> mapToTechnikIdList(List<Technik> technikList) {
        return technikList.stream()
                .map(Technik::getId)
                .collect(Collectors.toList());
    }
}
