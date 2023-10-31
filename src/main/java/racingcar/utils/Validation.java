package racingcar.utils;

import java.util.regex.Pattern;

public class Validation {
    private static final Integer NAME_LENGTH_MIN = 1;
    private static final Integer NAME_LENGTH_MAX = 5;

    public static void validateName(String name) {
        isValidNameLength(name);
        hasSpecialCharacter(name);
    }

    public static void isValidNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_MIN
                || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static void hasSpecialCharacter(String name) {
        if (Pattern.matches("\\W", name)) {
            throw new IllegalArgumentException();
        }
    }

}
