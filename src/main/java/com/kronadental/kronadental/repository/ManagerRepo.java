package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
    Manager findByIdAndActiveTrue(Long id);

    List<Manager> findAllByActiveTrue();
}
