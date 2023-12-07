package com.example.EmploymentManagementSystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.entities.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    
}
