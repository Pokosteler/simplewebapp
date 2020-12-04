package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    public Employee create(Employee employee) {
        entityManager.createNativeQuery("INSERT INTO employee (employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,cast(? as gender),?)")
                .setParameter(1, employee.getEmployeeId())
                .setParameter(2, employee.getFirstName())
                .setParameter(3, employee.getLastName())
                .setParameter(4, employee.getDepartmentId())
                .setParameter(5, employee.getJobTitle())
                .setParameter(6, employee.getGender().toString())
                .setParameter(7, employee.getDateOfBirth())
                .executeUpdate();
        return employee;
    }

    public Employee update(Employee employee) {
        entityManager.createNativeQuery("UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = cast(? as gender), date_of_birth = ? where employee_id = ?")
                .setParameter(1, employee.getFirstName())
                .setParameter(2, employee.getLastName())
                .setParameter(3, employee.getDepartmentId())
                .setParameter(4, employee.getJobTitle())
                .setParameter(5, employee.getGender().toString())
                .setParameter(6, employee.getDateOfBirth())
                .setParameter(7, employee.getEmployeeId())
                .executeUpdate();
        return employee;
    }

    public void delete(Employee employee) {
        Employee removeEmployee = get(employee.getEmployeeId());
        if (removeEmployee != null) {
            entityManager.remove(removeEmployee);
        }
    }

    public Employee get(Long employeeId) {
        for (Employee employee : getAll()) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }
}
