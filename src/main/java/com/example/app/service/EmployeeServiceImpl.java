package com.example.app.service;

import com.example.app.dao.EmployeeDao;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.pojo.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee existingEmployee=getEmployeeById(employeeId);
        if (existingEmployee == null) {
            throw new ResourceNotFoundException("Employee not found with ID: " + employeeId);
        }
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());
        return employeeDao.updateEmployee(existingEmployee);
    }
}
