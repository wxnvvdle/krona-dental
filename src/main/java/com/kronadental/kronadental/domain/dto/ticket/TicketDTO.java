package com.kronadental.kronadental.domain.dto.ticket;

import com.kronadental.kronadental.domain.data.Dentist;
import com.kronadental.kronadental.domain.data.Manager;
import com.kronadental.kronadental.domain.data.Technik;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.enums.LastStage;
import com.kronadental.kronadental.domain.enums.PreparingStage;
import com.kronadental.kronadental.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDTO {

    private Long id;

    private Status status;

    private PreparingStage preparingStage;

    private LastStage lastStage;

    private TechnikDTO technik;

    private DentistDTO dentist;

    private ManagerDTO manager;

}
