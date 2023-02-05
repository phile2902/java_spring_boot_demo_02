/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springboot.demo.service;

import com.springboot.demo.model.Employee;
import java.util.List;

public interface IEmployeeService {
    public Employee saveEmployee(Employee $employee);
    public List<Employee> getAllEmployees();
    public Employee getById(Long id);
    public Employee update(Employee employee, Long id);
    public void delete(Long id);
}
