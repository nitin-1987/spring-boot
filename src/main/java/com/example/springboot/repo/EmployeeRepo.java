package com.example.springboot.repo;

import com.example.springboot.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmployeeById(Long id);
}
