package com.example.app.dao;

import com.example.app.pojo.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }
}
