package racingcar.exception.cars;

public class DuplicateException extends IllegalArgumentException {
    public static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 자동차 이름이 있습니다.";

    public DuplicateException() {
        super(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
