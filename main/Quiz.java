package main;
import java.util.ArrayList;

import exceptions.InvalidAnswersException;
import exceptions.NotEnoughQuestionsException;
import exceptions.QuestionAlreadyExistsException;

public class Quiz {
    private ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) throws QuestionAlreadyExistsException{
        if(questions.contains(question)) throw new QuestionAlreadyExistsException();
        questions.add(question);
    }

    public void displayQuestionAt(int idx) throws NotEnoughQuestionsException{
        if(idx > questions.size() - 1) throw new InvalidAnswersException();
        questions.get(idx).display();
    }

    public float markQuiz(ArrayList<Integer> userAnswers) throws InvalidAnswersException{
        if(userAnswers.size() != questions.size()) throw new InvalidAnswersException();

        int correctAnswers = 0;

        for(int questionIdx = 0; questionIdx < questions.size(); questionIdx++){
            Question questionToMark = questions.get(questionIdx);
            int userAnswerToQuestion = userAnswers.get(questionIdx);

            if (questionToMark.isCorrectAnswer(userAnswerToQuestion)) {
                correctAnswers++;
            }
        }

        return calculateFinalGrade(correctAnswers);
    }

    private float calculateFinalGrade(int correctAnswers){
        float totalQuestions = questions.size() * 1.0f;
        float grade = (correctAnswers / totalQuestions) * 100;
        grade = Math.round(grade * 100) / 100;
        return grade;
    }

    public int getLength(){
        return questions.size();
    }
}
