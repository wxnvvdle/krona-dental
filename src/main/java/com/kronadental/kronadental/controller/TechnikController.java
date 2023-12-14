package com.kronadental.kronadental.controller;

import com.kronadental.kronadental.domain.dto.technik.CreateTechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.TechnikDTO;
import com.kronadental.kronadental.domain.dto.technik.UpdateTechnikDTO;
import com.kronadental.kronadental.service.TechnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technik")
public class TechnikController {

    @Autowired
    private TechnikService technikService;

    @GetMapping("/{id}")
    public TechnikDTO get(@PathVariable Long id) {
        return technikService.getById(id);
    }

    @GetMapping
    public List<TechnikDTO> getAll() {
        return technikService.getAll();
    }

    @PostMapping
    public TechnikDTO create(@RequestBody CreateTechnikDTO createTechnikDTO) {
        return technikService.create(createTechnikDTO);
    }

    @PutMapping("/{id}")
    public TechnikDTO update(@PathVariable Long id, @RequestBody UpdateTechnikDTO updateTechnikDTO) {
        return technikService.update(id, updateTechnikDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        technikService.delete(id);
    }
}
