package racingcar.utils;

public class InputValidator {

    public static void validateCarName(String name) {
        if (validateNameLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateNameLength(String name) {
        return !name.isEmpty() && name.length() <= 5;
    }
}
