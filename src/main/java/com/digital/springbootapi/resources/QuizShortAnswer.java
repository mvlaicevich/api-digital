package com.digital.springbootapi.resources;

public class QuizShortAnswer implements QuizStrategy {

    @Override
    public void displayQuestion(String question) {
        System.out.println(question + " (write a short answer)");
    }
@Override
    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
