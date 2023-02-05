/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springboot.demo.controller;

import com.springboot.demo.model.Employee;
import com.springboot.demo.service.IEmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/employees")
public class EmployeeController {
    
    private final IEmployeeService employeeService;
    
    @PostMapping()
    public ResponseEntity<Employee> save(@RequestBody Employee $employee)
    {
        return new ResponseEntity(employeeService.saveEmployee($employee), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Employee>> getAll()
    {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateById(@PathVariable Long id, @RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.update(employee, id), HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id)
    {
        employeeService.delete(id);
        
        return new ResponseEntity<>("Employee deleted successful", HttpStatus.OK);
    }
}
