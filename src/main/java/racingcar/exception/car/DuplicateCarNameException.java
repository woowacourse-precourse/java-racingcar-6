package racingcar.exception.car;

public class DuplicateCarNameException extends IllegalArgumentException {
    private static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복이 될 수 없습니다.";

    public DuplicateCarNameException() {
        super(DUPLICATE_CAR_NAME);
    }
}
