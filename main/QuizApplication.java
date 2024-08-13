package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import exceptions.NotEnoughQuestionsException;
import exceptions.QuestionAlreadyExistsException;

public class QuizApplication {
    
    private static final int TARGET_QUIZ_LENGTH = 2;
    private static ArrayList<Question> allQuestions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String q1 = "What is my name?";
        String[] q1A = {"Youssef", "Ahmed", "Omar", "Khaled"};
        Question q1Q = new Question(q1, q1A, 1);

        String q2 = "What is my age?";
        String[] q2A = {"22", "24", "26", "28"};
        Question q2Q = new Question(q2, q2A, 2);

        allQuestions.add(q1Q);
        allQuestions.add(q2Q);

        User user = new User("Youssef");
        Quiz quiz = compileQuiz(TARGET_QUIZ_LENGTH);
        conductQuiz(quiz, user);
    }

    private static Quiz compileQuiz(int targetQuizLength) throws NotEnoughQuestionsException{
        if(targetQuizLength > allQuestions.size()) throw new NotEnoughQuestionsException();

        Random random = new Random();
        Quiz createdQuiz = new Quiz();

        while(createdQuiz.getLength() < targetQuizLength){
            int randomIdx = random.nextInt(allQuestions.size());
            Question questionToAdd = allQuestions.get(randomIdx);

            try{
                createdQuiz.addQuestion(questionToAdd);
            } catch (QuestionAlreadyExistsException e){
                continue;
            }
        }

        return createdQuiz;
    }

    private static void conductQuiz(Quiz quiz, User user){

        for(int questionIdx = 0; questionIdx < quiz.getLength(); questionIdx++){
            quiz.displayQuestionAt(questionIdx);
            int userAnswer = readUserAnswer("Enter your answer: ");
            user.answerQuestion(questionIdx, userAnswer);
        }

        ArrayList<Integer> userAnswers = user.getQuizAnswers();
        float userGrade = quiz.markQuiz(userAnswers);
        System.out.println("Grade: " + userGrade);
    }

    private static int readUserAnswer(String prompt){
        while(true){
            try {
                System.out.println();
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                continue;
            }
        }
    }
}
