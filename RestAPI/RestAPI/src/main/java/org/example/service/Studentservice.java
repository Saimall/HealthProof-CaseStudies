package org.example.service;

import org.example.models.Student;
import org.example.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentservice {

    @Autowired
    private Studentrepo studentrepo;

    public Student AddStudent(Student student){

        return studentrepo.save(student);
    }

    public void deleteStudent(Long id){
        studentrepo.deleteById(id);
    }

    public Student updateEmployee(Long id,Student newstd){
        Optional<Student> oldstd= studentrepo.findById(id);

        oldstd.get().setEmail(newstd.getEmail());
        oldstd.get().setAge(newstd.getAge());
        oldstd.get().setName(newstd.getName());


        return  studentrepo.save(oldstd.get());
    }

    public List<Student> getallStudents(){
        return studentrepo.findAll();
    }

    public Student getstudentbyid(Long id){
        return studentrepo.findById(id).get();
    }

}
