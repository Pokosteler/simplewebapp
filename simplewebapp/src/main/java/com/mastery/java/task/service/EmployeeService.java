package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public List<Employee> findAll() {
        return employeeDao.getAll();
    }

    @Transactional
    public Employee create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Transactional
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Transactional
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    @Transactional
    public Employee get(Long employeeId) {
        return employeeDao.get(employeeId);
    }
}
