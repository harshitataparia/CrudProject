package com.honeywell.project.service;

import com.honeywell.project.repository.EmployeeRepository;
import com.honeywell.project.exception.EmployeNotFoundException;
import com.honeywell.project.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createNewEmployee(Employee employee)
    {
      return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id)
    {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(!employee.isPresent())
        {
            throw new EmployeNotFoundException("id - "+id);
        }

        return employee.get();
    }

    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }

    public void deleteById(Long id)
    {
        employeeRepository.deleteById(id);
    }
}
