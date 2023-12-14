package com.kronadental.kronadental.controller;

import com.kronadental.kronadental.domain.dto.manager.CreateManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.ManagerDTO;
import com.kronadental.kronadental.domain.dto.manager.UpdateManagerDTO;
import com.kronadental.kronadental.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/{id}")
    public ManagerDTO get(@PathVariable Long id) {
        return managerService.getById(id);
    }

    @GetMapping
    public List<ManagerDTO> getAll() {
        return managerService.getAll();
    }

    @PostMapping
    public ManagerDTO create(@RequestBody CreateManagerDTO createManagerDTO) {
        return managerService.create(createManagerDTO);
    }

    @PutMapping("/{id}")
    public ManagerDTO update(@PathVariable Long id, @RequestBody UpdateManagerDTO updateManagerDTO) {
        return managerService.update(id, updateManagerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        managerService.delete(id);
    }

}
