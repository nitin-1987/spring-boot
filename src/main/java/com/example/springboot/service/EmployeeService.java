package com.example.springboot.service;

import com.example.springboot.Employee;
import com.example.springboot.exception.UserNotFoundException;
import com.example.springboot.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long Id){
        employeeRepo.deleteById(Id);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow( () ->new UserNotFoundException("User by Id "+id+" not found"));
    }
}
