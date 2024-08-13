package exceptions;
public class QuizException extends RuntimeException {

    public QuizException() {
        super();
    }

    public QuizException(String errorMessage) {
        super(errorMessage);
    }
}
