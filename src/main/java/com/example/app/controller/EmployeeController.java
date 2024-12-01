package com.example.app.controller;

import com.example.app.exception.ResourceNotFoundException;
import com.example.app.pojo.Employee;
import com.example.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    protected static Logger logger = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployee(){
        logger.info("Requesting getAllEmployee");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        logger.info("Saving employee: " + employee);
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        logger.info("Requesting getEmployeeById for ID: {}", employeeId);
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found with ID: " + employeeId);
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId,@RequestBody Employee employee) {
        logger.info("Requesting updateEmployee");
        Employee updatedEmployee =employeeService.updateEmployee(employeeId,employee);
        return ResponseEntity.ok(updatedEmployee);
    }

}
