package com.student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.Entity.Student;
import com.student.demo.Exception.StudentNotFoundException;
import com.student.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> saveAllStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));
    }

    public List<Student> getStudentByName(String name) {
        List<Student> students = repository.findByName(name);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found with name: " + name);
        }
        return students;
    }

    public Student updateStudent(Student student) {
        int id = student.getId();
        repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Cannot update. Student not found with id: " + id));
        return repository.save(student);
    }

    public void deleteStudent(int id) {
        repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Cannot delete. Student not found with id: " + id));
        repository.deleteById(id);
    }

    public List<Student> getByAge(int age) {
        List<Student> students = repository.findByAge(age);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found with age: " + age);
        }
        return students;
    }

    public List<Student> getMarksGreaterThan(int marks) {
        List<Student> students = repository.findByMarksGreaterThan(marks);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found with marks greater than: " + marks);
        }
        return students;
    }

    public List<Student> getMarksLessThan(int marks) {
        List<Student> students = repository.findByMarksLessThan(marks);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found with marks less than: " + marks);
        }
        return students;
    }
}

















//package com.student.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.student.demo.Entity.Student;
//import com.student.demo.repository.StudentRepository;
//
//import java.util.List;
//import java.util.Optional;
// 
//@Service
//public class StudentService {
//    @Autowired
//    private StudentRepository repository;
// 
//    public StudentService(StudentRepository repository) {
//        this.repository = repository;
//    }
// 
//    public Student saveStudent(Student student) {
//        return repository.save(student);
//    }
// 
//    public List<Student> saveAllStudents(List<Student> students) {
//        return repository.saveAll(students);
//    }
// 
//    public List<Student> getAllStudents() {
//        return repository.findAll();
//    }
// 
//    public Optional<Student> getStudentById(int id) {
//        return repository.findById(id);
//    }
// 
//    public List<Student> getStudentByName(String name) {
//        return repository.findByName(name);
//    }
// 
//    public Student updateStudent(Student student) {
//        return repository.save(student);
//    }
// 
//    public void deleteStudent(int id) {
//        repository.deleteById(id);
//    }
// 
//    public List<Student> getByAge(int age) {
//        return repository.findByAge(age);
//    }
// 
//    public List<Student> getMarksGreaterThan(int marks) {
//        return repository.findByMarksGreaterThan(marks);
//    }
// 
//    public List<Student> getMarksLessThan(int marks) {
//        return repository.findByMarksLessThan(marks);
//    }
//}
// 
//
// 
