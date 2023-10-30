package racingcar.exception;

public class InvalidRacingCarNameLengthException extends IllegalArgumentException{
    private static final String INVALID_RACINGCAR_LENGTH_MESSAGE = "경주할 자동차의 이름은 다섯 글자 이하여야 합니다.";
    public InvalidRacingCarNameLengthException() {
        super(INVALID_RACINGCAR_LENGTH_MESSAGE);
    }
}
