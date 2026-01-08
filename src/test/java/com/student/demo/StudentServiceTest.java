//package com.student.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.student.demo.Entity.Student;
//import com.student.demo.Exception.StudentNotFoundException;
//import com.student.demo.repository.StudentRepository;
//import com.student.demo.service.StudentService;
//
//@ExtendWith(MockitoExtension.class)
//class StudentServiceTest {
//
//    @Mock
//    private StudentRepository repository;
//
//    @InjectMocks
//    private StudentService service;
//
//    // ===================== SAVE STUDENT =====================
//    @Test
//    void saveStudent_ShouldReturnSavedStudent() {
//
//        Student student = new Student();
//        student.setId(1);
//        student.setName("John");
//        student.setAge(20);
//        student.setMarks(85);
//
//        when(repository.save(student)).thenReturn(student);
//
//        Student saved = service.saveStudent(student);
//
//        assertNotNull(saved);
//        assertEquals("John", saved.getName());
//
//        verify(repository, times(1)).save(student);
//    }
//
//    // ===================== SAVE ALL STUDENTS =====================
//    @Test
//    void saveAllStudents_ShouldReturnSavedList() {
//
//        List<Student> students = Arrays.asList(
//                new Student(1, "John", 20, 80),
//                new Student(2, "Mike", 21, 90)
//        );
//
//        when(repository.saveAll(students)).thenReturn(students);
//
//        List<Student> result = service.saveAllStudents(students);
//
//        assertEquals(2, result.size());
//        verify(repository, times(1)).saveAll(students);
//    }
//
//    // ===================== GET ALL STUDENTS =====================
//    @Test
//    void getAllStudents_ShouldReturnList() {
//
//        List<Student> students = Arrays.asList(
//                new Student(1, "John", 20, 80),
//                new Student(2, "Mike", 21, 90)
//        );
//
//        when(repository.findAll()).thenReturn(students);
//
//        List<Student> result = service.getAllStudents();
//
//        assertEquals(2, result.size());
//        verify(repository, times(1)).findAll();
//    }
//
//    // ===================== GET STUDENT BY ID =====================
//    @Test
//    void getStudentById_WhenFound_ReturnStudent() {
//
//        Student student = new Student(1, "John", 20, 85);
//
//        when(repository.findById(1)).thenReturn(Optional.of(student));
//
//        Student result = service.getStudentById(1);
//
//        assertEquals("John", result.getName());
//        verify(repository, times(1)).findById(1);
//    }
//
//    @Test
//    void getStudentById_WhenNotFound_ThrowsException() {
//
//        when(repository.findById(1)).thenReturn(Optional.empty());
//
//        StudentNotFoundException ex = assertThrows(
//                StudentNotFoundException.class,
//                () -> service.getStudentById(1)
//        );
//
//        assertEquals("Student not found with id: 1", ex.getMessage());
//        verify(repository, times(1)).findById(1);
//    }
//
//    // ===================== GET STUDENT BY NAME =====================
//    @Test
//    void getStudentByName_WhenFound_ReturnList() {
//
//        List<Student> students = List.of(new Student(1, "John", 20, 85));
//
//        when(repository.findByName("John")).thenReturn(students);
//
//        List<Student> result = service.getStudentByName("John");
//
//        assertEquals(1, result.size());
//        verify(repository, times(1)).findByName("John");
//    }
//
//    @Test
//    void getStudentByName_WhenNotFound_ThrowsException() {
//
//        when(repository.findByName("John")).thenReturn(Collections.emptyList());
//
//        StudentNotFoundException ex = assertThrows(
//                StudentNotFoundException.class,
//                () -> service.getStudentByName("John")
//        );
//
//        assertEquals("No students found with name: John", ex.getMessage());
//        verify(repository, times(1)).findByName("John");
//    }
//
//    // ===================== UPDATE STUDENT =====================
//    @Test
//    void updateStudent_WhenExists_ReturnUpdatedStudent() {
//
//        Student student = new Student();
//        student.setId(1); // VERY IMPORTANT (fixes strict stubbing issue)
//        student.setName("John");
//        student.setAge(21);
//        student.setMarks(90);
//
//        when(repository.findById(1)).thenReturn(Optional.of(student));
//        when(repository.save(student)).thenReturn(student);
//
//        Student updated = service.updateStudent(student);
//
//        assertEquals(21, updated.getAge());
//        verify(repository, times(1)).findById(1);
//        verify(repository, times(1)).save(student);
//    }
//
//    // ===================== DELETE STUDENT =====================
//    @Test
//    void deleteStudent_WhenExists_DeleteSuccessfully() {
//
//        Student student = new Student(1, "John", 20, 85);
//
//        when(repository.findById(1)).thenReturn(Optional.of(student));
//
//        service.deleteStudent(1);
//
//        verify(repository, times(1)).findById(1);
//        verify(repository, times(1)).deleteById(1);
//    }
//
//    // ===================== GET BY AGE =====================
//    @Test
//    void getByAge_WhenFound_ReturnList() {
//
//        List<Student> students = List.of(new Student(1, "John", 20, 85));
//
//        when(repository.findByAge(20)).thenReturn(students);
//
//        List<Student> result = service.getByAge(20);
//
//        assertEquals(1, result.size());
//        verify(repository, times(1)).findByAge(20);
//    }
//
//    @Test
//    void getByAge_WhenNotFound_ThrowsException() {
//
//        when(repository.findByAge(20)).thenReturn(Collections.emptyList());
//
//        StudentNotFoundException ex = assertThrows(
//                StudentNotFoundException.class,
//                () -> service.getByAge(20)
//        );
//
//        assertEquals("No students found with age: 20", ex.getMessage());
//        verify(repository, times(1)).findByAge(20);
//    }
//
//    // ===================== MARKS GREATER THAN =====================
//    @Test
//    void getMarksGreaterThan_WhenFound_ReturnList() {
//
//        List<Student> students = List.of(new Student(1, "John", 20, 90));
//
//        when(repository.findByMarksGreaterThan(80)).thenReturn(students);
//
//        List<Student> result = service.getMarksGreaterThan(80);
//
//        assertEquals(1, result.size());
//        verify(repository, times(1)).findByMarksGreaterThan(80);
//    }
//
//    // ===================== MARKS LESS THAN =====================
//    @Test
//    void getMarksLessThan_WhenFound_ReturnList() {
//
//        List<Student> students = List.of(new Student(1, "John", 20, 60));
//
//        when(repository.findByMarksLessThan(70)).thenReturn(students);
//
//        List<Student> result = service.getMarksLessThan(70);
//
//        assertEquals(1, result.size());
//        verify(repository, times(1)).findByMarksLessThan(70);
//    }
//}
