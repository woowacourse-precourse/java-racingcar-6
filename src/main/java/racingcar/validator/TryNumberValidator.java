package racingcar.validator;

public class TryNumberValidator {
    private static final int MIN_TRY_NUMBER = 1;
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다";
    private static final String NOT_NATURAL_NUMBER_EXCEPTION_MESSAGE = "자연수만 입력 가능합니다";

    public static void validate(String number) {
        validateIsNumber(number);
        validateIsNaturalNumber(number);
    }

    private static void validateIsNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void validateIsNaturalNumber(String number) {
        int tryNumber = Integer.parseInt(number);
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
