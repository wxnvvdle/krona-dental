package com.kronadental.kronadental.controller;

import com.kronadental.kronadental.domain.dto.ticket.CreateTicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.TicketDTO;
import com.kronadental.kronadental.domain.dto.ticket.UpdateTicketDTO;
import com.kronadental.kronadental.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{id}")
    public TicketDTO get(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @GetMapping
    public List<TicketDTO> getAll() {
        return ticketService.getAll();
    }

    @PostMapping
    public TicketDTO create(@RequestBody CreateTicketDTO createTicketDTO) {
        return ticketService.create(createTicketDTO);
    }

    @PutMapping("/{id}")
    public TicketDTO update(@PathVariable Long id, @RequestBody UpdateTicketDTO updateTicketDTO) {
        return ticketService.update(id, updateTicketDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }
}
