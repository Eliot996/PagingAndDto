package com.example.paginganddto.employee.service;

import com.example.paginganddto.employee.dto.EmployeeDto;
import com.example.paginganddto.employee.model.Employee;
import com.example.paginganddto.employee.repo.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository repository;

    ModelMapper mapper = new ModelMapper();

    public List<EmployeeDto> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Employee> pagedResult = repository.findAll(paging);




        if(pagedResult.hasContent()) {
            return pagedResult.getContent()
                    .stream()
                    .map(employee -> mapper.map(employee, EmployeeDto.class))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<EmployeeDto>();
        }
    }
}
