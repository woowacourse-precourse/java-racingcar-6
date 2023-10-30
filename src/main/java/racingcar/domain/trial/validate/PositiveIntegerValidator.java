package racingcar.domain.trial.validate;

public class PositiveIntegerValidator {

    private static final String NEGATIVE_INTEGER = "시도 횟수는 양수로 입력하세요.";

    public static void validate(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER);
        }
    }
}
