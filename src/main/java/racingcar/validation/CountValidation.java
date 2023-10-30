package racingcar.validation;

public final class CountValidation extends InputValidation {

    public static void validate(String input) {
        if (isEmptyInput(input) || isNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean isNumeric(String input) {
        return input.chars().noneMatch(Character::isDigit);
    }

}
