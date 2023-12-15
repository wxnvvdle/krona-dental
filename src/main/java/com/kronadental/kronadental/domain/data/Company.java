package com.kronadental.kronadental.domain.data;

import com.kronadental.kronadental.domain.enums.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean active;

    @Column(name = "type")
    private CompanyType companyType;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Manager> managerList;

    @OneToMany(mappedBy = "company")
    private List<Dentist> dentistList;

    @OneToMany(mappedBy = "company")
    private List<Technik> technikList;

}
