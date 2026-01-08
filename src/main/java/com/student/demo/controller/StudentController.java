package com.student.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.student.demo.Entity.Student;
import com.student.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    // Constructor Injection (Best Practice)
    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    // READ ALL
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    // UPDATE with validation
    @PutMapping("/update")
    public Student updateStudent(@Valid @RequestBody Student student) {
        return service.updateStudent(student);
    }
    // 4. Get Students by Name
    @GetMapping("/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return service.getStudentByName(name);
    }

    // 5. Get Students by Age
    @GetMapping("/age/{age}")
    public List<Student> getStudentByAge(@PathVariable Integer age) {
        return service.getByAge(age);
    }

    // 6. Get Students with Marks Greater Than
    @GetMapping("/marks/greater/{marks}")
    public List<Student> getMarksGreaterThan(@PathVariable Integer marks) {
        return service.getMarksGreaterThan(marks);
    }

    // 7. Get Students with Marks Less Than
    @GetMapping("/marks/less/{marks}")
    public List<Student> getMarksLessThan(@PathVariable Integer marks) {
        return service.getMarksLessThan(marks);
    }


    // 9. Delete Student by ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }

  
    // 12. Get Failed Students (Marks < 35)
    @GetMapping("/failed")
    public List<Student> getFailedStudents() {
        return service.getMarksLessThan(35);
    }

    // 13. Welcome API
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Student Management API";
    }
}
