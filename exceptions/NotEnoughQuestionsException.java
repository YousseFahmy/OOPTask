package exceptions;

public class NotEnoughQuestionsException extends QuizException{

    public NotEnoughQuestionsException() {
        super();
    }

    public NotEnoughQuestionsException(String errorMessage) {
        super(errorMessage);
    }
    
}
