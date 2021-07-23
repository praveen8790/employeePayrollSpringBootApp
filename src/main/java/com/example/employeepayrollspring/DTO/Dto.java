package com.example.employeepayrollspring.DTO;

import com.example.employeepayrollspring.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dto {
    private String id;
    private String _name;
    private String _gender;
    private String[] _department;
    private String _salary;
    private String _profilePic;
    private String _startdate;

    public Dto(Employee employee) {
        this.id = employee.getId().toString();
        this._department= employee.get_department();
        this._name= employee.get_name();
        this._gender=employee.get_gender();
        this._profilePic=employee.get_profilePic();
        this._salary=employee.get_salary();
        this._startdate=employee.get_startdate();
    }


}
