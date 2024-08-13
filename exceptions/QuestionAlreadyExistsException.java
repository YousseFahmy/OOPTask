package exceptions;

public class QuestionAlreadyExistsException extends QuizException {
    public QuestionAlreadyExistsException() {
        super();
    }

    public QuestionAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
