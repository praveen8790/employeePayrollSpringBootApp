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
            employee1.set_name(employee.get_name());
            employee1.set_department(employee.get_department());
            employee1.set_gender(employee.get_gender());
            employee1.set_salary(employee.get_salary());
            employee1.set_profilePic(employee.get_profilePic());
            employee1.set_startdate(employee.get_startdate());
            return employeeRepository.save(employee1);
        }).get();
    }

    @Override
    public void deleteFromDB(Employee employee) {

    }
}
