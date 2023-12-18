package com.kronadental.kronadental.domain.data;

import com.kronadental.kronadental.domain.enums.LastStage;
import com.kronadental.kronadental.domain.enums.PreparingStage;
import com.kronadental.kronadental.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean active;

    @Column(name = "status")
    private Status status;

    @Column(name = "preparing_stage")
    @Enumerated(EnumType.STRING)
    private PreparingStage preparingStage;

    @Column(name = "last_stage")
    @Enumerated(EnumType.STRING)
    private LastStage lastStage;

    @ManyToOne
    private Technik technik;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Manager manager;

}
