package com.example.EmploymentManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "employee cannot be created without name")
    private String name;
    @NotBlank(message  = "employee cannot be created without email")
    @Email
    private String email;
    @NotBlank(message = "employee cannot be created without phone")
    private String phone;
    @NotBlank(message = "employee cannot be created without password")
    private String password;


    @NotNull(message = "Employee requires a manager id")
    @ManyToOne
    @JoinColumn(name="manager_id", referencedColumnName = "id")
    private Manager manager;

}
