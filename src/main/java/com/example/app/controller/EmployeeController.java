package com.example.app.controller;

import com.example.app.pojo.Employee;
import com.example.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {
    protected static Logger logger = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAllEmployees")

    public List<Employee> getAllEmployee(){

        logger.info("Requesting getAllEmployee");
        return employeeService.getAllEmployees();
    }
}
