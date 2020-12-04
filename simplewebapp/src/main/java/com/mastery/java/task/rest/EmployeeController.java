package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping(value = "/{employeeId}")
    public Employee get(@PathVariable(value = "employeeId") Long employeeId) {
        return employeeService.get(employeeId);
    }

    @PostMapping(value = "/add")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @DeleteMapping(value = "/delete/{employeeId}")
    public void delete(Employee employee) {
        employeeService.delete(employee);
    }

    @PutMapping(value = "/update/{employeeId}")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }
}
