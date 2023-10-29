package racingcar.util;

public class InputValidator {

    public static boolean isValidCarNameLength(String input) {
        if(isEmptyInput(input)) return false;
        if(isInvalidNameLength(input)) return false;
        return true;
    }

    public static boolean isNumeric(String input) {
        if(isEmptyInput(input)) return false;
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean isEmptyInput(final String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }

    private static boolean isInvalidNameLength(String input) {
        if(input.length() < 1 || input.length() > 5) return true;
        return false;
    }
}
