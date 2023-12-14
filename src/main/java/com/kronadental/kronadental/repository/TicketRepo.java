package com.kronadental.kronadental.repository;

import com.kronadental.kronadental.domain.data.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
}
