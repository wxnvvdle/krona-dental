package com.kronadental.kronadental.domain.mapper;

import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TechnikMapper {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private TicketMapper ticketMapper;

    public TechnikDTO toDTO(Technik technik) {
        TechnikDTO technikDTO = new TechnikDTO();

        technikDTO.setId(technik.getId());
        technikDTO.setName(technik.getName());
        technikDTO.setCompany(companyMapper.toDTO(technik.getCompany()));
        technikDTO.setTicketDTOList(ticketMapper.toDTO(technik.getTicketList()));

        return technikDTO;
    }

    public List<TechnikDTO> toDTO(List<Technik> technikList) {
        List<TechnikDTO> technikDTOList = new ArrayList<>();

        technikList.forEach(technik -> technikDTOList.add(toDTO(technik)));

        return technikDTOList;
    }
}
