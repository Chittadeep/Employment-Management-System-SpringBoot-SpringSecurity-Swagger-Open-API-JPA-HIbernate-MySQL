package com.example.EmploymentManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmploymentManagementSystem.entities.Employee;
import com.example.EmploymentManagementSystem.exceptions.EntityDoesNotExistException;
import com.example.EmploymentManagementSystem.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees()
    {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).orElseThrow(()-> new EntityDoesNotExistException("Employee with the given Id does not exist"));
    }

    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee)
    {
        Employee employeeExists = getEmployeeById(employee.getId());
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(int employeeId)
    {
        employeeRepository.delete(getEmployeeById(employeeId));
        return true;
    }

    /*
    private List<Employee> getEmployeesByManagerId(int managerId)
    {

    }

    private List<Employee> getEmployeesByDepartmentId(int departmentId)
    {

    }
    */
}
