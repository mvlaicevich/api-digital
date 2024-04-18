package com.digital.springbootapi.controller;


import com.digital.springbootapi.model.Lesson;
import com.digital.springbootapi.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PostMapping
    public Lesson addLesson(@RequestBody Lesson lesson) {
        return lessonService.addLesson(lesson);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson lesson) {
        return lessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}
