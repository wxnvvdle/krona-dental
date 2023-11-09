package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DentistMapper {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private TicketMapper ticketMapper;

    public DentistDTO toDTO(Dentist dentist) {
        DentistDTO dentistDTO = new DentistDTO();

        dentistDTO.setId(dentist.getId());
        dentistDTO.setName(dentist.getName());
        dentistDTO.setCompany(companyMapper.toDTO(dentist.getCompany()));
        dentistDTO.setTicketList(ticketMapper.toDTO(dentist.getTicketList()));

        return dentistDTO;
    }

    public List<DentistDTO> toDTO(List<Dentist> dentistList) {
        List<DentistDTO> dentistDTOList = new ArrayList<>();

        dentistList.forEach(dentist -> dentistDTOList.add(toDTO(dentist)));

        return dentistDTOList;

    }

}
