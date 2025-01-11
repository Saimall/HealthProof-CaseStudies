package org.example.repository;

import org.example.models.Employee;
import org.example.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {
}
