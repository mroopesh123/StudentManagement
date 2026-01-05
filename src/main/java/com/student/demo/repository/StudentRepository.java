package com.student.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.student.demo.Entity.Student;
import java.util.List;
 
public interface StudentRepository extends JpaRepository<Student, Integer> {
 
    List<Student> findByName(String name);
 
    List<Student> findByAge(int age);
 
    List<Student> findByMarksGreaterThan(int marks);
 
    List<Student> findByMarksLessThan(int marks);
}