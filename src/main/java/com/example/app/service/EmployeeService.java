package com.example.app.service;

import com.example.app.pojo.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public interface EmployeeService {

    public List<Employee> getAllEmployees();
}
