package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.dto.manager.CreateManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.UpdateManagerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    public Manager create(CreateManagerDTO createManagerDTO);

    @Mapping(target = "id", ignore = true)
    public Manager update(Manager manager, UpdateManagerDTO updateManagerDTO);

    public ManagerDTO toDTO(Manager manager);

}
