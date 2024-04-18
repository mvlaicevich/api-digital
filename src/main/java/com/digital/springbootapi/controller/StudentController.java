package com.digital.springbootapi.controller;

import com.digital.springbootapi.exception.UserAlreadyExistsException;
import com.digital.springbootapi.model.Student;
import com.digital.springbootapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {


    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        //email is mandatory
        if (student.getEmail() == null) {
            throw new RuntimeException("Email is mandatory");
        }
        //email already exists
        if (studentService.getStudentByEmail(student.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists");
        }
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

}
