package com.example.JustManyTwo.controller;

import com.example.JustManyTwo.model.Employee;
import com.example.JustManyTwo.model.EmployeeResponse;
import com.example.JustManyTwo.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class EmployeeController
    {
        @Autowired
        private  EmployeeService employeeService;

        @PostMapping(path = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity <EmployeeResponse> createEmployee(@RequestBody Employee employee)
        {
            EmployeeResponse employeeResponse =employeeService.createEmployee(employee);
            return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
        }

        @GetMapping(path = "/employees/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
            Employee employee= employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }

        @DeleteMapping(path = "/employees/{id}")
        public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.ok().build();
        }

        /*@PutMapping(path = "/employees/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> updateById(@PathVariable Long id, Employee employee){
            employeeService.updateById(id, employee);
            return ResponseEntity.ok().build();
        }*/




    }
