package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TechnikMapper.class)
public interface TechnikMapperList {

    public List<TechnikDTO> toDTOList(List<Technik> technikList);

}
