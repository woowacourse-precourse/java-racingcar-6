package racingcar.model;

public class AttemptNumValidator {
    private static final String INPUT_IS_NOT_NATURAL_NUMBER = "입력값이 자연수가 아닙니다.";
    private static final String ATTEMPT_NUMBER_REGEX = "^[1-9]+$";

    public static int validateNumber(String number) {
        if (!number.matches(ATTEMPT_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NATURAL_NUMBER);
        }
        return Integer.parseInt(number);
    }
}