package racingcar.exception.round.totalNumberOfRounds;

public class NonPositiveIntegerException extends IllegalArgumentException {
    public static final String NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE = "양수를 입력하지 않았습니다.";

    public NonPositiveIntegerException() {
        super(NON_POSITIVE_INTEGER_EXCEPTION_MESSAGE);
    }
}
