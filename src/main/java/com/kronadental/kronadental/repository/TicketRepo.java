package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket,Long> {

    @Query("SELECT t FROM Ticket t WHERE t.id IN (?1)")
    List<Ticket> findAllByIdAndActiveTrue(List<Long> idList);

    Ticket findByIdAndActiveTrue(Long id);

    List<Ticket> findAllByActiveTrue();
}
