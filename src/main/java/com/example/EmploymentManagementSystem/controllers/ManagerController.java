package com.example.EmploymentManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.EmploymentManagementSystem.entities.Manager;
import com.example.EmploymentManagementSystem.services.ManagerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    
    @Operation(
        tags = "GET managers",
        description = "Get all managers along with their descriptions",
        responses = {
            @ApiResponse(
                description="success",
                responseCode = "200"
            )
        }
    )
    @GetMapping("/allManagers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        return new ResponseEntity<List<Manager>>(managerService.getAllManagers(), HttpStatus.OK);
    }

    @Operation(
        tags = "GET managers",
        description = "Get manager's description via his id",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "not manager with this id is present",
                responseCode = "400"
            )
        }
    )
    @GetMapping("/manager/{managerId}")
    public ResponseEntity<Manager> getManager(@PathVariable int managerId) {
        return new ResponseEntity<Manager>(managerService.getManagerById(managerId), HttpStatus.OK);
    }


    @Operation(
        tags = "CREATE manager",
        description = "create a new manager",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "bad request",
                responseCode = "400"
            )
        }
    )
    @PostMapping("/manager")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        return new ResponseEntity<Manager>(managerService.createManager(manager), HttpStatus.CREATED);
    }
    
    @Operation(
        tags = "UPDATE manager",
        description = "update a manager",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no manager with this id exists",
                responseCode = "400"
            )
        }
    )
    @PutMapping("/manager")
    public ResponseEntity<Manager> updateManager(@RequestBody Manager manager) {
        
        return new ResponseEntity<Manager>(managerService.updateManager(manager), HttpStatus.OK);
    }

    @Operation(
        tags = "DELETE manager",
        description = "delete a manager",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no manager with this id exists",
                responseCode = "400"
            )
        }
    )
    @DeleteMapping("/manager/{managerId}")
    public ResponseEntity<Boolean> deleteManager(@PathVariable int managerId)
    {
        return new ResponseEntity<Boolean>(managerService.deleteManager(managerId), HttpStatus.OK);
    }
}
