package racingcar.function;

public class NumberChecker {
    private static final String ERROR_INVALID_DIGITS = "숫자로 입력 하세요.";
    private static final String ERROR_NOT_POSITIVE_NUMBER = "0 이상의 값을 입력 하세요";
    private static final String ERROR_IS_NULL = "값을 입력 하세요";


    public static int validate(String inputNumber) {
        validateNotNull(inputNumber);
        validateOnlyDigits(inputNumber);
        return validatePositiveNumber(inputNumber);
    }

    private static void validateNotNull(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException(ERROR_IS_NULL);
        }
    }

    private static void validateOnlyDigits(String inputNumber) {
        for (char character : inputNumber.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException(ERROR_INVALID_DIGITS);
            }
        }
    }

    private static int validatePositiveNumber(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
        return number;
    }
}
