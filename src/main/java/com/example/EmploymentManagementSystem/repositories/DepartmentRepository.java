package com.example.EmploymentManagementSystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    
}
