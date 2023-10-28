package racingcar;

import java.util.List;

public class Validation {

    public static void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String name : names) {
            if (name.isBlank() || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateGameCount(String input) {
        try {
            int inputNum = Integer.parseInt(input);

            if (inputNum <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
