package com.student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.student.demo.Entity.Student;
import com.student.demo.service.StudentService;

import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;
 
    public StudentController(StudentService service) {
        this.service = service;
    }
 
    // 1. Create student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
 
    // 2. Create multiple students
    @PostMapping("/addAll")
    public List<Student> addAllStudents(@RequestBody List<Student> students) {
        return service.saveAllStudents(students);
    }
 
    // 3. Get all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
 
    // 4. Get student by id
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

 
    // 5. Get student by name
    @GetMapping("/name/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return service.getStudentByName(name);
    }
 
    // 6. Get student by age
    @GetMapping("/age/{age}")
    public List<Student> getByAge(@PathVariable int age) {
        return service.getByAge(age);
    }
 
    // 7. Get marks greater than
    @GetMapping("/marks/greater/{marks}")
    public List<Student> getMarksGreater(@PathVariable int marks) {
        return service.getMarksGreaterThan(marks);
    }
 
    // 8. Get marks less than
    @GetMapping("/marks/less/{marks}")
    public List<Student> getMarksLess(@PathVariable int marks) {
        return service.getMarksLessThan(marks);
    }
 
    // 9. Update student
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
 
    // 10. Delete student by id
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
 
    // 11. Count students
    @GetMapping("/count")
    public long countStudents() {
        return service.getAllStudents().size();
    }
 
    // 12. Check student exists
    @GetMapping("/exists/{id}")
    public boolean studentExists(@PathVariable int id) {
        return service.getStudentById(id) != null;
    }
 
    // 13. Get top scorers (marks > 80)
    @GetMapping("/top")
    public List<Student> getTopStudents() {
        return service.getMarksGreaterThan(80);
    }
 
    // 14. Get failed students (marks < 35)
    @GetMapping("/failed")
    public List<Student> getFailedStudents() {
        return service.getMarksLessThan(35);
    }
 
    // 15. Welcome API
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Student Management API";
    }
}