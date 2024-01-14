package com.example.EmploymentManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.EmploymentManagementSystem.entities.Department;
import com.example.EmploymentManagementSystem.exceptions.EntityDoesNotExistException;
import com.example.EmploymentManagementSystem.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments()
    {
        return (List<Department>) departmentRepository.findAll();
    }

    public Department getDepartment(int depId)
    {
        return departmentRepository.findById(depId).orElseThrow(()-> new EntityDoesNotExistException("no department exists with the given id"));
    }

    public Department createDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department)
    {
        Department departmentExists = getDepartment(department.getId());
        return departmentRepository.save(department);
    }

    public boolean deleteDepartment(int id)
    {
        departmentRepository.delete(getDepartment(id));
        return true;
    }

    /*
     public Department getDepartmentByManagerId(int managerId)
     {
        
     } 
     */
}
