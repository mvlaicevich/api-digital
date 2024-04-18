package com.digital.springbootapi.service;

import com.digital.springbootapi.model.Lesson;
import com.digital.springbootapi.repostory.LessonRepository;
import com.digital.springbootapi.resources.Quiz;
import com.digital.springbootapi.resources.QuizMultipleChoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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


    public boolean checkQuizAnswers() {
        List<String> questions = Arrays.asList("What is 2+2?", "Earth is flat?");
        List<String> answers = Arrays.asList("4", "false");

        Quiz mcQuiz = new Quiz(new QuizMultipleChoice(), questions, answers);
        mcQuiz.displayQuiz();
        System.out.println("Answer is correct: " + mcQuiz.checkAnswer(0, "4"));
        return true;

    }
}