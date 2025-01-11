package org.example.controller;

import org.example.models.Employee;
import org.example.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private Employeeservice employeeservice;

    @PostMapping("/add")
    public Employee AddEmployee(@RequestBody Employee emp){
        return employeeservice.AddEmployee(emp);
    }

    @DeleteMapping("/delete/:id")
    public void deleteEmployee(@RequestParam Long id){
        employeeservice.deleteEmployee(id);
    }

    @PutMapping("/update/:id")
    public Employee updateEmployee(@RequestParam Long id, @RequestBody Employee newemp){
        return employeeservice.updateEmployee(id,newemp);
    }

    @GetMapping("/get/:id")
    public Employee getemployeebyid(@RequestParam Long id){
        return employeeservice.getemployeebyid(id);
    }

    @GetMapping("/get")
    public List<Employee> getallemployees(){
        return employeeservice.getallemployees();
    }


}
