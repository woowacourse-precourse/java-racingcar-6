package racingcar.valid;

public class ValidationManager {

    private static final String COMMA = ",";
    private static final int MIN_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(String inputCarNames) {
        for (String carName : inputCarNames.split(COMMA)) {
            validateInputEmpty(carName);
            validateCarNameLength(carName);
        }
    }

    public static void validateTryCount(String inputTryCount) {
        validateInputEmpty(inputTryCount);
        validateTryCountIsNumeric(inputTryCount);
        validateTryCountStartWithZero(inputTryCount);
    }

    private static void validateInputEmpty(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameLength(String inputCarName) {
        if (!isValidCarNameLength(inputCarName)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidCarNameLength(String inputCarName) {
        return inputCarName.length() > MIN_NAME_LENGTH && inputCarName.length() <= MAX_NAME_LENGTH;
    }

    private static void validateTryCountIsNumeric(String inputTryCount) {
        if (!isNumeric(inputTryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateTryCountStartWithZero(String inputTryCount) {
        if (isStartWithZero(inputTryCount)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isNumeric(String inputTryCount) {
        for (int i = 0; i < inputTryCount.length(); i++) {
            if (!Character.isDigit(inputTryCount.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStartWithZero(String inputTryCount) {
        return '0' == inputTryCount.charAt(0);
    }

}
