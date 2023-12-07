package com.example.EmploymentManagementSystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.EmploymentManagementSystem.entities.Manager;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {
    
}
