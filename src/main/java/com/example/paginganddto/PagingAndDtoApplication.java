package com.example.paginganddto;

import com.example.paginganddto.employee.model.Employee;
import com.example.paginganddto.employee.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PagingAndDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagingAndDtoApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(EmployeeRepository repo) {
        return (args) -> {

            /**
             *  Orders
             */
            final List<Employee> orders = new ArrayList<>();
            orders.add(new Employee("Cam", "Vi", "CVI@mail.com"));
            orders.add(new Employee("Matt", "Eliot", "MEliot@mail.com"));
            orders.add(new Employee("Sofi", "Peterson", "SPeterson@mail.com"));
            orders.add(new Employee("Lasse", "Junkers", "LJunkers@mail.com"));
            orders.add(new Employee("Mo", "Fukerwolff", "MFukerwolff@mail.com"));

            repo.saveAll(orders);
        };

    }

}
