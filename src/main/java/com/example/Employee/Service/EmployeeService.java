package com.example.Employee.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public String addEmployee(Employee employee){
        employeeRepository.save(employee);
        return "Employee Info Added";
    }

    public List<Employee> fetchAllEmployee(){
       return employeeRepository.findAll();
    }

    public Employee fetchEmployeeById(long id){
       return employeeRepository.findById(id).get();
    }

}
