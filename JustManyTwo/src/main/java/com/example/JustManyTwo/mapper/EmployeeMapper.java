package com.example.JustManyTwo.mapper;

import com.example.JustManyTwo.entity.EmployeeEntity;
import com.example.JustManyTwo.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee entityToEmployee (EmployeeEntity employeeEntity);

    EmployeeEntity employeeToEntity (Employee employee);


}
