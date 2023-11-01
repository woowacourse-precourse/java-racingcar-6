package racingcar.domain.util.validator;

public class ChallengeValidator {
    public static void validate(String input) {
        isNum(input);
    }

    private static void isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid number of attempts input");
        }
    }
}
