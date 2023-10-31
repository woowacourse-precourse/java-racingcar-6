package racingcar.exception;

public class InsufficientRaceCountException extends IllegalArgumentException {
    public InsufficientRaceCountException() {
        super("경주 횟수는 1회 이상이어야 합니다.");
    }
}
