package racingcar.domain.exception;

public final class DuplicateCarNameException extends IllegalArgumentException {
    public static final String DUPLICATE_CAR_NAME_EXCEPTION_MESSAGE = "중복된 차 이름이 존재합니다";

    public DuplicateCarNameException() {
        super(DUPLICATE_CAR_NAME_EXCEPTION_MESSAGE);
    }
}
