package com.digital.springbootapi.service;


import com.digital.springbootapi.model.Lesson;
import com.digital.springbootapi.repostory.LessonRepository;
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
public class LessonServiceTest {

    @InjectMocks
    private LessonService lessonService;

    @Mock
    private LessonRepository lessonRepository;

    @Test
    public void testGetAllLessons() {
        when(lessonRepository.findAll()).thenReturn(Arrays.asList(new Lesson(), new Lesson()));

        List<Lesson> result = lessonService.getAllLessons();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetLessonById() {
        Lesson lesson = new Lesson();
        when(lessonRepository.findById(1L)).thenReturn(Optional.of(lesson));

        Lesson result = lessonService.getLessonById(1L);

        assertEquals(lesson, result);
    }

    @Test
    public void testAddLesson() {
        Lesson lesson = new Lesson();
        when(lessonRepository.save(lesson)).thenReturn(lesson);

        Lesson result = lessonService.addLesson(lesson);

        assertEquals(lesson, result);
    }

    @Test
    public void testUpdateLesson() {
        Lesson lesson = new Lesson();
        when(lessonRepository.findById(1L)).thenReturn(Optional.of(lesson));
        when(lessonRepository.save(lesson)).thenReturn(lesson);

        Lesson result = lessonService.updateLesson(1L, lesson);

        assertEquals(lesson, result);
    }

    @Test
    public void testDeleteLesson() {
        doNothing().when(lessonRepository).deleteById(1L);

        lessonService.deleteLesson(1L);

        verify(lessonRepository, times(1)).deleteById(1L);
    }

}