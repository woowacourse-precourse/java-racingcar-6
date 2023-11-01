package racingcar.util;

public class Validator {

    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int MIN_OF_TRY_COUNT = 1;
    private static final String BLANK = " ";

    public static String checkName(String name) {
        validateNameLength(name);
        validateNameBlank(name);
        return name;
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNameBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkTryCount(String rawTryCount) {
        int tryCount = validateIsNotNumber(rawTryCount);
        return validateInRange(tryCount);
    }

    private static int validateIsNotNumber(String rawTryCount) {
        try {
            return Integer.parseInt(rawTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateInRange(int tryCount) {
        if (tryCount < MIN_OF_TRY_COUNT) {
            throw new IllegalArgumentException();
        }
        return tryCount;
    }

}
