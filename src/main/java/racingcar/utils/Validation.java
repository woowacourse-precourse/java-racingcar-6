package racingcar.utils;

import java.util.regex.Pattern;

public class Validation {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final Pattern specialChar = Pattern.compile("\\W");
    private static final Pattern exceptNumber = Pattern.compile("\\D");

    public static void validateName(String name) {
        isValidNameLength(name);
        hasSpecialCharacter(name);
    }

    private static void isValidNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_MIN
                || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static void hasSpecialCharacter(String name) throws IllegalArgumentException {
        if (specialChar.matcher(name).find()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTrial(String trial) throws IllegalArgumentException {
        if (exceptNumber.matcher(trial).find()) {
            throw new IllegalArgumentException();
        }
    }
}
