package racingcar.domain;

public class InputValidator {
    private static final int NAME_LENGTH = 5;

    public static void validateNamesInput(String names) {
        if (!names.matches("^([a-zA-Z0-9]{1,5},)*[a-zA-Z0-9]{1,5}$"))
            throw new IllegalArgumentException();
    }

    public static void validateCountInput(String count) {
        if (!isValidNumber(count))
            throw new IllegalArgumentException();
    }

    private static boolean isValidNumber(String num) {
        return num.chars().allMatch(Character::isDigit);
    }
}
