package com.example.paginganddto.employee.repo;

import com.example.paginganddto.employee.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends PagingAndSortingRepository<Employee, Long> {

}
