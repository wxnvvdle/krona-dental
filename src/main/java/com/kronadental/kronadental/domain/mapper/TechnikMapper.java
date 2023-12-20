package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.technik.CreateTechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.UpdateTechnikDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TechnikMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    public Technik create(Technik technik, CreateTechnikDTO createTechnikDTO);

    @Mapping(target = "id", ignore = true)
    public Technik update(Technik technik, UpdateTechnikDTO updateTechnikDTO);

    public TechnikDTO toDTO(Technik technik);

}
