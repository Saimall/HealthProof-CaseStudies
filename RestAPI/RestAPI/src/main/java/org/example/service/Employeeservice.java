package org.example.service;

import org.example.models.Employee;
import org.example.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Employeeservice {

    @Autowired
    private Employeerepo employeerepo;

    public Employee AddEmployee(Employee employee){

        return employeerepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeerepo.deleteById(id);
    }

    public Employee updateEmployee(Long id,Employee newemp){
        Optional<Employee> oldemp= employeerepo.findById(id);
        oldemp.get().setName(newemp.getName());
        oldemp.get().setDesignation(newemp.getDesignation());
       return  employeerepo.save(oldemp.get());
    }

    public List<Employee> getallemployees(){
        return employeerepo.findAll();
    }

    public Employee getemployeebyid(Long id){
        return employeerepo.findById(id).get();
    }

}
