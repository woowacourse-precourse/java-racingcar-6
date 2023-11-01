package racingcar.model;

public class TryValidator {

    private static final Integer ZERO = 0;
    private static final String POSITIVE_INTEGER_RANGE_ERROR = "시도 횟수는 0보다 커야 합니다.";

    public static void validate(Integer input) {
        if (input <= ZERO) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_RANGE_ERROR);
        }
    }
}
