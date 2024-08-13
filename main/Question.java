package main;
public class Question {

    private String questionText;
    private String[] answersArray;
    private int correctAnswerIdx;

    public Question(String questionText, String[] answers, int correctAnswerIdx) {
        this.questionText = questionText;
        this.answersArray = answers;
        this.correctAnswerIdx = correctAnswerIdx;
    }

    public void display(){
        System.out.println(questionText);
        System.out.println("1) " + answersArray[0]);
        System.out.println("2) " + answersArray[1]);
        System.out.println("3) " + answersArray[2]);
        System.out.println("4) " + answersArray[3]);
    }

    public boolean isCorrectAnswer(int answer){
        return answer == correctAnswerIdx;
    }

    public String[] getAnswersArray() {
        return answersArray;
    }

    public String getQuestionText() {
        return questionText;
    }
    
}