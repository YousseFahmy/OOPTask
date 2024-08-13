package exceptions;

public class InvalidAnswersException extends QuizException{

    public InvalidAnswersException() {
        super();
    }

    public InvalidAnswersException(String errorMessage) {
        super(errorMessage);
    }
    
}
