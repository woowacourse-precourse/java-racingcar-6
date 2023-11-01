package racingcar.exception;

public class CarNameDuplicateException extends IllegalArgumentException {

    private static final String exceptionMessage = "자동차 이름이 중복되었습니다.";

    public CarNameDuplicateException() {
        super(exceptionMessage);
    }
}
