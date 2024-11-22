package com.example.app.dao;

import com.example.app.pojo.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public interface EmployeeDao {
    public List<Employee> getAllEmployees();
}
