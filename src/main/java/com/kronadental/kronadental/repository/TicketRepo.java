package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
    List<Ticket> findAllByIdAndActiveTrue(List<Long> IdList);

    Ticket findByIdAndActiveTrue(Long id);

    List<Ticket> findAllByActiveTrue();
}
