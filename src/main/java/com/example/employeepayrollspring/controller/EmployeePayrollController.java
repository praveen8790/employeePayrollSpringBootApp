package com.example.employeepayrollspring.controller;

import com.example.employeepayrollspring.DTO.Dto;
import com.example.employeepayrollspring.entity.Employee;
import com.example.employeepayrollspring.service.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.GET,
        RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.POST},origins = "*")
@RestController
@RequestMapping("/EmployeePayrollDB")
public class EmployeePayrollController {
    @Autowired
    private IEmployeeServices employeeServices;
    @PostMapping
    public ResponseEntity add(@RequestBody Dto dto){
        employeeServices.addToDB(new Employee(dto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id,@RequestBody Dto dto){
        return new ResponseEntity<>(employeeServices.updateDB(id,new Employee(dto)),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        employeeServices.deleteFromDB(id);
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.OPTIONS)
                .build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Dto>> getEmployees(){
        return new ResponseEntity<List<Dto>>(employeeServices.get().stream().map(employee -> {
            return new Dto(employee);
        }).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }


}
