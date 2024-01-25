package com.example.EmploymentManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmploymentManagementSystem.entities.Employee;
import com.example.EmploymentManagementSystem.repositories.EmployeeRepository;
import com.example.EmploymentManagementSystem.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(
        tags = "GET employees",
        description = "Get all employees along with their description",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            )
        }
    )
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    

    @Operation(
        tags = "GET employees",
        description = "Get employees with his/her id",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no such employee present",
                responseCode = "400"
            )
        }
    )
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }


    @Operation(
        tags = "CREATE employees",
        description = "Create employee",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            )
        }
    )
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @Operation(
        tags = "UPDATE employee",
        description = "Update employee",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no such employee present",
                responseCode = "400"
            )
        }
    )
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.CREATED);
    }
    

    @Operation(
        tags = "DELETE Employee",
        description = "Delete employee",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no such employee present",
                responseCode = "400"
            )
        }
    )
    @DeleteMapping("employee/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable int employeeId)
    {
        return new ResponseEntity<Boolean>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }
}
