package com.rawdebun.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rawdebun.ecommerce.entity.Employee;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
