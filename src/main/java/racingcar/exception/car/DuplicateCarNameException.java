package racingcar.exception.car;

public class DuplicateCarNameException extends IllegalArgumentException {
    private static final String DUPLICATE_CAR_NANE_MESSAGE = "중복된 자동차 이름입니다.";

    public DuplicateCarNameException() {
        super(DUPLICATE_CAR_NANE_MESSAGE);
    }
}
