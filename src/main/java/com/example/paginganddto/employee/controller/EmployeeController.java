package com.example.paginganddto.employee.controller;

import com.example.paginganddto.employee.dto.EmployeeDto;
import com.example.paginganddto.employee.model.Employee;
import com.example.paginganddto.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeService service;

    ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        if (pageSize <= 0) return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        if (pageNo < 0) return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);

        List<EmployeeDto> list = service.getAllEmployees(pageNo, pageSize, sortBy).stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<EmployeeDto>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
