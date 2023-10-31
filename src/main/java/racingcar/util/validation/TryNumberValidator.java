package racingcar.util.validation;

public class TryNumberValidator {

    private static final Integer MIN_TRY_NUMBER = 1;
    private static final String SMALLER_THAN_MIN_NUMBER_MESSAGE = "%s 이상의 정수값만 입력할 수 있습니다.";

    private TryNumberValidator() {
    }

    public static void validateTryNumber(Integer number) {
        if (isLessThanMinTryNumber(number)) {
            String errorMessage = String.format(SMALLER_THAN_MIN_NUMBER_MESSAGE, MIN_TRY_NUMBER);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isLessThanMinTryNumber(Integer number) {
        return number < MIN_TRY_NUMBER;
    }
}
