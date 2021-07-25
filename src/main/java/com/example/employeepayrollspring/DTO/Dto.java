package com.example.employeepayrollspring.DTO;

import com.example.employeepayrollspring.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
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
        this._department= employee.getDepartment();
        this._name= employee.getName();
        this._gender=employee.getGender();
        this._profilePic=employee.getProfilePic();
        this._salary=employee.getSalary();
        this._startdate=employee.getStartdate();
    }

    public Dto() {

    }


    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
