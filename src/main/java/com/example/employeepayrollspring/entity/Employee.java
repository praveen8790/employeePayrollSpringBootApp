package com.example.employeepayrollspring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee {

    private Integer id;
    private String _name;
    private String _gender;
    private String[] _department;
    private String _salary;
    private String _profilePic;
    private String _startdate;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public Employee(String _name, String _gender, String[] _department, String _salary, String _profilePic, String _startdate) {
        this._name = _name;
        this._gender = _gender;
        this._department = _department;
        this._salary = _salary;
        this._profilePic = _profilePic;
        this._startdate = _startdate;
    }
}
