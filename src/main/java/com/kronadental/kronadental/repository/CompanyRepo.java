package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company, Long> {

    Company findCompanyByIdAndActiveTrue(Long id);
    List<Company> findAllByActiveTrue();

}
