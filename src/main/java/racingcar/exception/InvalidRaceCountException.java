package racingcar.exception;

public class InvalidRaceCountException extends IllegalArgumentException{
    private static final String INVALID_RACE_MESSAGE = "경주 횟수는 자연수로 입력해야 합니다.";
    public InvalidRaceCountException() {
        super(INVALID_RACE_MESSAGE);
    }
}
