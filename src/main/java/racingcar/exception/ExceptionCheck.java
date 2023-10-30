package racingcar.exception;

public class ExceptionCheck {

    public static void iterateNumberValidation(int iterateNumber) {
        if (iterateNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
