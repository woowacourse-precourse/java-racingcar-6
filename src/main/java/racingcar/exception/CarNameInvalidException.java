package racingcar.exception;

public class CarNameInvalidException extends IllegalArgumentException {

    private static final String exceptionMessage = "자동차 이름은 5글자 이하로 지어야 합니다.";

    public CarNameInvalidException() {
        super(exceptionMessage);
    }
}
