package com.kronadental.kronadental.domain.dto.ticket;

import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.enums.LastStage;
import com.kronadental.kronadental.domain.enums.PreparingStage;
import com.kronadental.kronadental.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateTicketDTO {

    private Status status;

    private PreparingStage preparingStage;

    private LastStage lastStage;

    private Long technikId;

    private Long dentistId;

    private Long managerId;

}
