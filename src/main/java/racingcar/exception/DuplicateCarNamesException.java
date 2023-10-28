package racingcar.exception;

public class DuplicateCarNamesException extends IllegalArgumentException {

    private static final String DUPLICATE_CAR_NAMES_MESSAGE = "중복된 차 이름이 있습니다.";

    public DuplicateCarNamesException() {
        super(DUPLICATE_CAR_NAMES_MESSAGE);
    }
}
