package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Long> {
}
