package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Technik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnikRepo extends JpaRepository<Technik, Long> {
    Technik findByIdAndActiveTrue(Long id);

    List<Technik> findAllByActiveTrue();
}
