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

    @GetMapping("/allDepartments")
    public ResponseEntity<List<Department>> geAllDepartments() {
        return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/department/{deptId}")
    public ResponseEntity<Department> getMethodName(@PathVariable int deptId) {
        return new ResponseEntity<Department>(departmentService.getDepartment(deptId), HttpStatus.OK);
    }
    
    @PostMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.createDepartment(department), HttpStatus.OK);
    }
    
    @PutMapping("/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(departmentService.updateDepartment(department), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/department/{deptId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable int deptId)
    {
        return new ResponseEntity<Boolean>(departmentService.deleteDepartment(deptId), HttpStatus.OK); 
    }
}
