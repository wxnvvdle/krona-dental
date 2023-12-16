package com.kronadental.kronadental.domain.data;

import com.kronadental.kronadental.domain.enums.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Technik {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean active;

    @Column(name = "name")
    private String name;

    @Column(name = "specialization")
    private Specialization specialization;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "technik")
    private List<Ticket> ticketList;

}
