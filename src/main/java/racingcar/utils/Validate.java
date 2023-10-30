package racingcar.utils;

import java.util.regex.Pattern;
import racingcar.config.Configuration;

public class Validate {

    public static void validateName(String name) {
        isValidNameLength(name);
        hasSpecialCharacter(name);
    }

    public static void isValidNameLength(String name) throws IllegalArgumentException {
        if (name.length() < Configuration.NAME_LENGTH_MIN.getValue()
                || name.length() > Configuration.NAME_LENGTH_MAX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void hasSpecialCharacter(String name) {
        if (Pattern.matches("\\W", name)) {
            throw new IllegalArgumentException();
        }
    }

}
