package racingcar.exceptions.runtime;

public class DuplicatedCarNameException extends RuntimeException {

    private static final String DUPLICATED_CAR_NAME_MESSAGE = "중복된 자동차 이름이 존재합니다.";

    public DuplicatedCarNameException() {
        super(DUPLICATED_CAR_NAME_MESSAGE);
    }
}
