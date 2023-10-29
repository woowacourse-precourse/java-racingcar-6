package racingcar.utility;

import java.util.List;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    public static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isInNameRange(String input) {
        return input.length() <= 5;
    }

}
