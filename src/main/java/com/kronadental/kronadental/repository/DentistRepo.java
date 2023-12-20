package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepo extends JpaRepository<Dentist, Long> {

    List<Dentist> findAllByActiveTrue();
    Dentist findDentistByIdAndActiveTrue(Long id);
    Dentist findByIdAndActiveTrue(Long id);
}
