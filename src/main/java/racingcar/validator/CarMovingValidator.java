package racingcar.validator;

public class CarMovingValidator {
    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException();

    public static void validateMovingNumber(int movingNumber) {
        validateMovingNotNegative(movingNumber);
        validateMovingSmallerThan10(movingNumber);
    }

    private static void validateMovingNotNegative(int movingNumber) {
        if (movingNumber < 0) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateMovingSmallerThan10(int movingNumber) {
        if (movingNumber >= 10) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }
}
