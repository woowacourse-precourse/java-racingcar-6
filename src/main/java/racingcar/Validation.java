package racingcar;

public class Validation {

    public static void validateCarNames(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException();
        }

        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
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
