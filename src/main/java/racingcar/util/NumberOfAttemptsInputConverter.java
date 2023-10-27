package racingcar.util;

public class NumberOfAttemptsInputConverter {

    private static final int MIN_NUMBER_OF_ATTEMPTS = 1;
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE =
            "유효하지 않은 입력값 입니다. 시도 횟수는 1이상 정수만 입력 가능합니다. 입력값: ";

    private NumberOfAttemptsInputConverter() {
    }

    public static int convert(String input) {
        int numberOfAttempts = validateAndParseInt(input);
        validateGreaterThanMinRange(numberOfAttempts);
        return numberOfAttempts;
    }

    private static int validateAndParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE + str);
        }
    }

    public static void validateGreaterThanMinRange(int value) {
        if (value < MIN_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE + value);
        }
    }

}
