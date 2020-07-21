package com.honeywell.project.controller;

import com.honeywell.project.model.Employee;
import com.honeywell.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        try
        {
            Employee createdEmployee = employeeService.createNewEmployee(employee);
            return new ResponseEntity<>(createdEmployee,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/employee/{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
    {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getListOfEmployee()
    {
        List<Employee> listOfEmployee = employeeService.getAllEmployee();
        if (listOfEmployee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listOfEmployee,HttpStatus.OK) ;
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id)
    {

        try {
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
