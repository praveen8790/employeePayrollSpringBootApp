package com.example.employeepayrollspring.service;

import com.example.employeepayrollspring.entity.Employee;

import java.util.List;

public interface IEmployeeServices {
    void addToDB(Employee employee);

    List<Employee> get();

    Employee updateDB(Integer id, Employee employee);

    void deleteFromDB(Integer id);
}
