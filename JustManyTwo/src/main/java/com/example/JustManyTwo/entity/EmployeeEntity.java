package com.example.JustManyTwo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "Employee")
@NoArgsConstructor
public class EmployeeEntity
    {
        @Id
        @SequenceGenerator(name = "emp_Seq", sequenceName = "emp_Seq", initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "emp_Seq")
        private Long id;

        private String firstName;

        private String lastName;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "employee_department",
                joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"))
        private Set<DepartmentEntity> department;


    }
