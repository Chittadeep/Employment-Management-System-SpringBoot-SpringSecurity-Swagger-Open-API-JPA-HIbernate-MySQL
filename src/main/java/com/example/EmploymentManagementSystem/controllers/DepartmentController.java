package com.example.EmploymentManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.EmploymentManagementSystem.entities.Department;
import com.example.EmploymentManagementSystem.services.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Operation(
        tags = "GET departments",
        description = "Get All departments along with their description",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            )
        }
    )
    @GetMapping("/allDepartments")
    public ResponseEntity<List<Department>> geAllDepartments() {
        return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @Operation(
        tags = "GET departments",
        description = "Get the department with the id",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no such department present",
                responseCode = "400"
            )
        }
    )
    @GetMapping("/department/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int deptId) {
        return new ResponseEntity<Department>(departmentService.getDepartment(deptId), HttpStatus.OK);
    }
    
    
    @Operation(
        tags = "CREATE department",
        description = "create a department",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            )
        }
    )
    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.createDepartment(department), HttpStatus.OK);
    }
    
    @Operation(
        tags = "UPDATE department",
        description = "update a department",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no such department present",
                responseCode = "400"
            )
        }
    )
    @PutMapping("/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.updateDepartment(department), HttpStatus.CREATED);
    }
    
    @Operation(
        tags = "DELETE department",
        description = "delete a department",
        responses = {
            @ApiResponse(
                description = "success",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "no such department present",
                responseCode = "400"
            )
        }
    )
    @DeleteMapping("/department/{deptId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable int deptId)
    {
        return new ResponseEntity<Boolean>(departmentService.deleteDepartment(deptId), HttpStatus.OK); 
    }
}
