package com.example.JustManyTwo.controller;

import com.example.JustManyTwo.model.Department;
import com.example.JustManyTwo.model.DepartmentResponse;
import com.example.JustManyTwo.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class DepartmentController
    {
       /* @Autowired
        private DepartmentService departmentService;

        *//*@GetMapping (path = "/departments/{deptName}", produces = MediaType.APPLICATION_JSON_VALUE)
        private ResponseEntity<Void> updateByName( @PathVariable String deptName)
        {
            departmentService.findByName(deptName);
            return ResponseEntity.ok().build();

        }*/

    }
