package com.example.EmploymentManagementSystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info = @Info(
        title = "Employment Management System API",
        description = "This api - project shows CRUD for Spring boot projct including use of open api and spring security",
        summary = "This api - project shows CRUD for Spring boot projct including use of open api and spring security",
        termsOfService = "t&c",
        contact = @Contact(
            name = "Chittadeep",
            email = "mailchittadeep@gmail.com"
        ),
        license = @License
        (
            name = "Your License No"
        ),
        version = "v1"
    )
)
public class OpenApiConfig {
    
}
