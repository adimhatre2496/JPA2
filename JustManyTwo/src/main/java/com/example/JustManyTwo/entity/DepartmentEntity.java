package com.example.JustManyTwo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Department")
public class DepartmentEntity
    {
        @Id
        @SequenceGenerator(name = "depo_Seq", sequenceName = "depo_Seq", initialValue = 100, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "depo_Seq")
        private Long id;

        @Column(name = "Dept_Name")
        private String deptName;

        @ManyToMany(mappedBy = "department",cascade = CascadeType.ALL)
        private Set <EmployeeEntity>  employee;

    }
