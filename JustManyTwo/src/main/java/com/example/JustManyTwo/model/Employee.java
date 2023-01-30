package com.example.JustManyTwo.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee
    {
        private String firstName;
        private String lastName;
        private Set<Department> department;

    }
