package racingcar.exception.count;

public class NoRemainingRoundsException extends RuntimeException {
    private static final String NOT_REMAIN_ROUND_MESSAGE = "진행할 라운드가 남아있지 않습니다.";

    public NoRemainingRoundsException() {
        super(NOT_REMAIN_ROUND_MESSAGE);
    }
}
