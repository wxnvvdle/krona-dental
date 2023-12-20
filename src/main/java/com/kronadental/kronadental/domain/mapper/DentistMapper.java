package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.dto.dentist.CreateDentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.UpdateDentistDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DentistMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    public Dentist create(CreateDentistDTO createDentistDTO);

    @Mapping(target = "id", ignore = true)
    public Dentist update(@MappingTarget Dentist dentist, UpdateDentistDTO updateDentistDTO);

    public DentistDTO toDTO(Dentist dentist);


}
