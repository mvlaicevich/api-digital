package com.digital.springbootapi.resources;

import java.util.List;

public class Quiz {
    private QuizStrategy strategy;
    private List<String> questions;
    private List<String> answers;

    public Quiz(QuizStrategy strategy, List<String> questions, List<String> answers) {
        this.strategy = strategy;
        this.questions = questions;
        this.answers = answers;
    }

    public void displayQuiz() {
        for (String question : questions) {
            strategy.displayQuestion(question);
        }
    }

    public boolean checkAnswer(int questionIndex, String answer) {
        return strategy.checkAnswer(answer, answers.get(questionIndex));
    }
}
