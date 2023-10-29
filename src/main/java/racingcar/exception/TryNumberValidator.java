package racingcar.exception;

public class TryNumberValidator {

    public static final Integer MIN_TRY_NUMBER = 1;
    public static final String SMALLER_THAN_MIN_NUMBER_MESSAGE = " 이상의 정수값만 입력할 수 있습니다.";

    private TryNumberValidator() {
    }

    public static void validateTryNumber(Integer number) {
        if (isLessThanMinTryNumber(number)) {
            throw new IllegalArgumentException(MIN_TRY_NUMBER + SMALLER_THAN_MIN_NUMBER_MESSAGE);
        }
    }

    private static boolean isLessThanMinTryNumber(Integer number) {
        return number < MIN_TRY_NUMBER;
    }
}
