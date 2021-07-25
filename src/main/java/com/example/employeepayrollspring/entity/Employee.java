package com.example.employeepayrollspring.entity;

import com.example.employeepayrollspring.DTO.Dto;
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
    private String name;
    private String gender;
    private String[] department;
    private String salary;
    private String profilePic;
    private String startdate;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public Employee(String _name, String _gender, String[] _department, String _salary, String _profilePic, String _startdate) {
        this.name = _name;
        this.gender = _gender;
        this.department = _department;
        this.salary = _salary;
        this.profilePic = _profilePic;
        this.startdate = _startdate;
    }
    public  Employee(Dto dto){
        this.id= Integer.valueOf(dto.getId());
        this.name = dto.get_name();
        this.gender = dto.get_gender();
        this.department = dto.get_department();
        this.salary = dto.get_salary();
        this.profilePic = dto.get_profilePic();
        this.startdate = dto.get_startdate();
    }
}
