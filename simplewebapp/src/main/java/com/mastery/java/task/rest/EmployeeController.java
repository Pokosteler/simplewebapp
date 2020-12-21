package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
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
    public Employee getById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.get(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @DeleteMapping(value = "/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("employeeId") Long id) {
        employeeService.delete(getById(id));
    }

    @PutMapping(value = "/{employeeId}")
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
