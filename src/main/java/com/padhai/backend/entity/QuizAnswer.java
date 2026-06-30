package com.padhai.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_answers")
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_attempt_id", nullable = false)
    private QuizAttempt quizAttempt;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false)
    private String selectedAnswer;

    @Column(nullable = false)
    private boolean correct;

    public QuizAnswer() {
    }

    public Long getId() {
        return id;
    }

    public QuizAttempt getQuizAttempt() {
        return quizAttempt;
    }

    public Question getQuestion() {
        return question;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuizAttempt(QuizAttempt quizAttempt) {
        this.quizAttempt = quizAttempt;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}