package com.digital.springbootapi.service;


import com.digital.springbootapi.model.Student;
import com.digital.springbootapi.repostory.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Test
    public void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(new Student(), new Student()));

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.addStudent(student);

        assertEquals(student, result);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.updateStudent(1L, student);

        assertEquals(student, result);
    }

    @Test
    public void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(1L);

        assertEquals(student, result);
    }

}