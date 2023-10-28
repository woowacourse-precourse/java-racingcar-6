package racingcar.exception;

public class ExceptionCheck {
    public static void nameLengthValidation(String carName) {
        if (!(carName.length() <= 5)) {
            throw new IllegalArgumentException();
        }
    }

    public static void iterateNumberValidation(int iterateNumber) {
        if (iterateNumber <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
