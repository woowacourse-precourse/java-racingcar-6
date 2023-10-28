package racingcar.validator;

public class CarValidator {

    private static final int CHECK_IF_TRY_COUNT_LESS_THAN_ZERO = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String STRING_REGEX = "^[\\w]*$";

    public static void checkTryCount(int tryCount) {
        if (tryCount < CHECK_IF_TRY_COUNT_LESS_THAN_ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
