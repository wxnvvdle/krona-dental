package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Long> {
}
