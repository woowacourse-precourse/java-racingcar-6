package racingcar.validation;

public final class CountValidation extends InputValidation {

    public static void isNumeric(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

}
