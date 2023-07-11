package com.example.Employee.Controller;


import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employeeApi")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping(path = "/add")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/fetch")
    public List<Employee> fetchAllEmployee(){
       return employeeService.fetchAllEmployee();
    }

    @GetMapping(path = "/fetch/{id}")
    public Employee fetchEmployeeById(@PathVariable Long id){
       return employeeService.fetchEmployeeById(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Exists with id: " + id));

        updateEmployee.setName(updateEmployee.getName());
        updateEmployee.setAge(updateEmployee.getAge());
        updateEmployee.setMobNo(updateEmployee.getMobNo());
        updateEmployee.setEmail(updateEmployee.getEmail());

        employeeRepository.save(employeeDetails);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not exists with id: " + id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
