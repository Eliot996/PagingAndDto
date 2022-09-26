package com.example.paginganddto.employee.controller;

import com.example.paginganddto.employee.model.Employee;
import com.example.paginganddto.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Employee> list = service.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
