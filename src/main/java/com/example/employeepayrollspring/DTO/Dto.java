package com.example.employeepayrollspring.DTO;

import com.example.employeepayrollspring.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@Component
public class Dto {

    private String id;
    @NotEmpty(message = "Name cannot be Empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",message = "Employee name invalid")
    private String _name;
    @Pattern(regexp = "Male|Female",message = "Gender needs to be Male or Female")
    private String _gender;
    @NotNull(message = "departments should not be empty")
    private List<String> _department;
    @Min(value = 300000,message = "Min wage should be more than 300000")
    private String _salary;
    @NotBlank(message = "profilePic cannot be empty")
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

    public String getId() {
        return id;
    }
}
