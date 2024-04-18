package com.digital.springbootapi.resources;

public interface QuizStrategy {
    void displayQuestion(String question);

    boolean checkAnswer(String userAnswer, String correctAnswer);

}
