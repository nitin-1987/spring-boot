package com.example.springboot;


import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employee=employeeService.findAllEmployee();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/find/{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Long Id){
        Employee employee=employeeService.findEmployeeById(Id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);

    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Long employeeId){

        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
