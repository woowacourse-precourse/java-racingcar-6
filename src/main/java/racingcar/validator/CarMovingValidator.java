package racingcar.validator;

import static racingcar.constant.ValidatorConstants.MAXIMUM_MOVING_NUMBER;
import static racingcar.constant.ValidatorConstants.MINIMUM_MOVING_NUMBER;

public class CarMovingValidator {
    private static final IllegalArgumentException ILLEGAL_ARGUMENT_EXCEPTION = new IllegalArgumentException();

    public static void validateMovingNumber(int movingNumber) {
        validateMovingNotNegative(movingNumber);
        validateMovingSmallerThan10(movingNumber);
    }

    private static void validateMovingNotNegative(int movingNumber) {
        if (movingNumber < MINIMUM_MOVING_NUMBER) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }

    private static void validateMovingSmallerThan10(int movingNumber) {
        if (movingNumber > MAXIMUM_MOVING_NUMBER) {
            throw ILLEGAL_ARGUMENT_EXCEPTION;
        }
    }
}
