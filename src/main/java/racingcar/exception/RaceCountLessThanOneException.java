package racingcar.exception;

public class RaceCountLessThanOneException extends CustomException {
    public RaceCountLessThanOneException() {
        super("최소 한 번의 경주는 진행되어야 합니다.");
    }
}
