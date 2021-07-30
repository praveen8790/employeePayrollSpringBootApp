package com.example.employeepayrollspring.repository;

import com.example.employeepayrollspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//    @Query(value = "select * from employee,employee_department where id = deptid and department =:department",nativeQuery = true)
//    List<Employee> findEmployeeByDepartment(String department);
}
