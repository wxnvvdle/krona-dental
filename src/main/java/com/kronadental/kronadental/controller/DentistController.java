package com.kronadental.kronadental.controller;

import com.kronadental.kronadental.domain.dto.dentist.CreateDentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.DentistDTO;
import com.kronadental.kronadental.domain.dto.dentist.UpdateDentistDTO;
import com.kronadental.kronadental.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentist")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping("/{id}")
    public DentistDTO get(@PathVariable Long id) {
        return dentistService.getById(id);
    }

    @GetMapping
    public List<DentistDTO> getAll() {
        return dentistService.getAll();
    }

    @PostMapping
    public DentistDTO create(@RequestBody CreateDentistDTO createDentistDTO) {
        return dentistService.create(createDentistDTO);
    }

    @PutMapping("/{id}")
    public DentistDTO update(@PathVariable Long id, @RequestBody UpdateDentistDTO updateDentistDTO) {
        return dentistService.update(id, updateDentistDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dentistService.delete(id);
    }
}
