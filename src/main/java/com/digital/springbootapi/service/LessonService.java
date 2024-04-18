package com.digital.springbootapi.service;

import com.digital.springbootapi.model.Lesson;
import com.digital.springbootapi.repostory.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LessonService {

    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long id, Lesson lessonDetails) {
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        if (lesson != null) {
            lesson.setTitle(lessonDetails.getTitle());
            lesson.setStatus(lessonDetails.getStatus());
            lesson.setTeacher(lessonDetails.getTeacher());
            return lessonRepository.save(lesson);
        }
        return null;
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}