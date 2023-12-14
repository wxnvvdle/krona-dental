package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepo extends JpaRepository<Dentist, Long> {
}
