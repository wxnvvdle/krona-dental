package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ManagerMapper.class)
public interface ManagerMapperList {

    public List<ManagerDTO> toDTOList(List<Manager> managerList);

}
