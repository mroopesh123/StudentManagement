package com.student.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.student.demo.Entity.Student;
import java.util.List;
 
public interface StudentRepository extends JpaRepository<Student, Integer> {
 
    List<Student> findByName(String name);
 
    List<Student> findByAge(Integer age);
 
    List<Student> findByMarksGreaterThan(Integer marks);
 
    List<Student> findByMarksLessThan(Integer marks);
}