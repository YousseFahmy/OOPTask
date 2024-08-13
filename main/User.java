package main;

import java.util.ArrayList;

public class User {
    private String username;
    private int answeredQuestionsCount;
    private ArrayList<Integer> quizAnswers;

    public User(String username) {
        this.username = username;
        this.answeredQuestionsCount = 0;
        this.quizAnswers = new ArrayList<>();
    }

    public void answerQuestion(int questionIdx, int userAnswer){
        quizAnswers.add(userAnswer);
        answeredQuestionsCount++;
    }

    public int getAnsweredQuestionsCount() {
        return answeredQuestionsCount;
    }

    public ArrayList<Integer> getQuizAnswers() {
        return quizAnswers;
    }

    public String getUsername() {
        return username;
    }
}
