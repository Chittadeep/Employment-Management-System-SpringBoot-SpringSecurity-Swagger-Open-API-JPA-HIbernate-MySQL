package com.example.EmploymentManagementSystem.controllers;

import java.util.List;

import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.EmploymentManagementSystem.entities.Manager;
import com.example.EmploymentManagementSystem.services.ManagerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    
    @GetMapping("/allManagers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        return new ResponseEntity<List<Manager>>(managerService.getAllManagers(), HttpStatus.OK);
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<Manager> getManager(@PathVariable int managerId) {
        return new ResponseEntity<Manager>(managerService.getManagerById(managerId), HttpStatus.OK);
    }
    
    @PostMapping("/manager")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        return new ResponseEntity<Manager>(managerService.createManager(manager), HttpStatus.CREATED);
    }
    
    @PutMapping("/manager")
    public ResponseEntity<Manager> updateManager(@RequestBody Manager manager) {
        
        return new ResponseEntity<Manager>(managerService.updateManager(manager), HttpStatus.OK);
    }

    @DeleteMapping("/manager/{managerId}")
    public ResponseEntity<Boolean> deleteManager(@PathVariable int managerId)
    {
        return new ResponseEntity<Boolean>(managerService.deleteManager(managerId), HttpStatus.OK);
    }
}
