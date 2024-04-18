package com.digital.springbootapi.controller;

import com.digital.springbootapi.model.Lesson;
import com.digital.springbootapi.service.LessonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LessonService lessonService;

    @Test
    public void testGetAllLessons() throws Exception {
        when(lessonService.getAllLessons()).thenReturn(Arrays.asList(new Lesson(), new Lesson()));

        mockMvc.perform(get("/lessons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetLessonById() throws Exception {
        Lesson lesson = new Lesson();
        when(lessonService.getLessonById(1L)).thenReturn(lesson);

        mockMvc.perform(get("/lessons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testAddLesson() throws Exception {
        Lesson lesson = new Lesson();
        when(lessonService.addLesson(lesson)).thenReturn(lesson);

        mockMvc.perform(post("/lessons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Lesson Title\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateLesson() throws Exception {
        Lesson lesson = new Lesson();
        when(lessonService.updateLesson(1L, lesson)).thenReturn(lesson);

        mockMvc.perform(put("/lessons/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Updated Title\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteLesson() throws Exception {
        doNothing().when(lessonService).deleteLesson(1L);

        mockMvc.perform(delete("/lessons/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(lessonService, times(1)).deleteLesson(1L);
    }

}