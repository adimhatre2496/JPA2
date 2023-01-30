package com.example.JustManyTwo.service;

import com.example.JustManyTwo.entity.DepartmentEntity;
import com.example.JustManyTwo.entity.EmployeeEntity;
import com.example.JustManyTwo.mapper.EmployeeMapper;
import com.example.JustManyTwo.model.Employee;
import com.example.JustManyTwo.model.EmployeeResponse;
import com.example.JustManyTwo.repository.DepartmentRepository;
import com.example.JustManyTwo.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;
    @Autowired
    public DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeMapper employeeMapper;

    public EmployeeResponse createEmployee(Employee employee)
    {
        EmployeeEntity employeeEntity=null;

        employeeEntity= employeeMapper.employeeToEntity(employee);
        employeeRepository.save(employeeEntity);

        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        return employeeResponse;

    }


    public Employee getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
        Employee employee = new Employee();
        if (employeeEntityOptional.isPresent()) {

            employee = employeeMapper.entityToEmployee(employeeEntityOptional.get());
            log.info("Fetching.....");
        } else {
            log.info(" ID {} not Found", id);
        }
        return employee;

    }

    public void deleteEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
        if ((employeeEntityOptional.isPresent())){
            employeeRepository.deleteById(id);
            log.info("Deleting the Data");

        }
        else{
            log.info(" ID {} not Found", id);
        }
    }

    /*public void updateById(Long id, Employee employee) {
        EmployeeEntity employeeEntity= employeeRepository.getOne(id);
        DepartmentEntity departmentEntity= departmentRepository.getOne(employeeRepository.getOne(id));
    }*/
}
