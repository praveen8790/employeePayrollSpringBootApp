package com.example.employeepayrollspring.controller;

import com.example.employeepayrollspring.DTO.Dto;
import com.example.employeepayrollspring.entity.Employee;
import com.example.employeepayrollspring.service.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/EmployeePayrollDB")
public class EmployeePayrollController {
    @Autowired
    private IEmployeeServices employeeServices;
    @CrossOrigin
    @PostMapping
    public ResponseEntity add(@RequestBody Employee employee){
        employeeServices.addToDB(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServices.updateDB(id,employee),HttpStatus.ACCEPTED);
    }
    @CrossOrigin
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Dto>> getEmployees(){
        return new ResponseEntity<List<Dto>>(employeeServices.get().stream().map(employee -> {
            return new Dto(employee);
        }).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }
}
