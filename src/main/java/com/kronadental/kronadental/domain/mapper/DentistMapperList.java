package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = DentistMapper.class)
public interface DentistMapperList {

    public List<DentistDTO> toDTOList(List<Dentist> dentistList);


}
