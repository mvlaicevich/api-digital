package com.digital.springbootapi.resources;

public class QuizTrueFalse implements QuizStrategy{


    @Override
    public void displayQuestion(String question) {

    }

    @Override
    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        return false;
    }
}
