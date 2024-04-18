package com.digital.springbootapi.resources;

public class QuizMultipleChoice implements QuizStrategy {

    @Override
    public void displayQuestion(String question) {
        System.out.println(question + " (true/false)");
    }

    @Override
    public boolean checkAnswer(String userAnswer, String correctAnswer) {

        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
