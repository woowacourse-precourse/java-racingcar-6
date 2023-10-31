package racingcar.utils.validator;

public class NoWhitespaceValidator {

    public static boolean validate(String input) {
        return !input.contains(" ");
    }
}
