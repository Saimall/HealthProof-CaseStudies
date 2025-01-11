package org.example.controller;


import org.example.models.Student;

import org.example.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private Studentservice studentservice;

    @PostMapping("/add")
    public Student AddEmployee(@RequestBody Student std){
        return studentservice.AddStudent(std);
    }

    @DeleteMapping("/delete/:id")
    public void deleteEmployee(@RequestParam Long id){
        studentservice.deleteStudent(id);
    }

    @PutMapping("/update/:id")
    public Student updateEmployee(@RequestParam Long id, @RequestBody Student newstd){
        return studentservice.updateEmployee(id,newstd);
    }

    @GetMapping("/get/:id")
    public Student getstudentbyid(@RequestParam Long id){
        return studentservice.getstudentbyid(id);
    }

    @GetMapping("/get")
    public List<Student> getallstudents(){
        return studentservice.getallStudents();
    }
}
