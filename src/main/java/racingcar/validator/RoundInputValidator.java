package racingcar.validator;

public class RoundInputValidator {
    private static String REGEX_NUMBER = "^[1-9][0-9]*$";

    public static void checkRoundNumberFormat(String round) {
        if (!round.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
