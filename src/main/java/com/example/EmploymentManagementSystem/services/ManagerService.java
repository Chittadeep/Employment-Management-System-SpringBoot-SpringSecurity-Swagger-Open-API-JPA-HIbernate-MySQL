package com.example.EmploymentManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.EmploymentManagementSystem.entities.Manager;
import com.example.EmploymentManagementSystem.exceptions.EntityDoesNotExistException;
import com.example.EmploymentManagementSystem.repositories.ManagerRepository;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    
    public List<Manager> getAllManagers()
    {
        return (List<Manager>) managerRepository.findAll();
    }

    public Manager getManagerById(int id)
    {
        return managerRepository.findById(id).orElseThrow(()->new EntityDoesNotExistException("the manager with this id does not exist"));
    }

    public Manager createManager(Manager manager)
    {
        return managerRepository.save(manager);
    }

    public Manager updateManager(Manager manager)
    {
        Manager managerExists = getManagerById(manager.getId());
        return managerRepository.save(manager);
    }

    public boolean deleteManager(int managerId)
    {
        managerRepository.delete(getManagerById(managerId));
        return true;
    }

    /*
    public Manager getManagerByDeptId(int deptId)
    {   

    }
    */
}
