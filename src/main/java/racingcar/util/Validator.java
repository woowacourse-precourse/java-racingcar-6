package racingcar.util;

public class Validator {

    public static String checkName(String name) {
        validateNameLength(name);
        validateNameBlank(name);
        return name;
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNameBlank(String name) {
        if (name.contains(" ")) {
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
        if (tryCount < 1) {
            throw new IllegalArgumentException();
        }
        return tryCount;
    }

}
