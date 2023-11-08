package racingcar.domain.util.validator;

public class ChallengeValidator {
    private static final String INVALID_NUMBER_ERROR_MESSAGE = "Invalid number of attempts input.";

    public static void validate(String input) {
        isNum(input);
    }

    private static void isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR_MESSAGE);
        }
    }
}
