package com.example.employeepayrollspring.service;

import com.example.employeepayrollspring.entity.Employee;
import com.example.employeepayrollspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices implements IEmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addToDB(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateDB(Integer id, Employee employee) {
        return employeeRepository.findById(id).map(employee1 -> {
            employee1.setName(employee.getName());
            employee1.setDepartment(employee.getDepartment());
            employee1.setGender(employee.getGender());
            employee1.setSalary(employee.getSalary());
            employee1.setProfilePic(employee.getProfilePic());
            employee1.setStartdate(employee.getStartdate());
            return employeeRepository.save(employee1);
        }).get();
    }

    @Override
    public void deleteFromDB(Integer id) {
        employeeRepository.deleteById(id);
    }
}
