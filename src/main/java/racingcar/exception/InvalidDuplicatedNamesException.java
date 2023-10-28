package racingcar.exception;

public class InvalidDuplicatedNamesException extends IllegalArgumentException{
    private static final String INVALID_DUPLICATED_NAMES_MESSAGE = "[에러] 중복된 이름이 있습니다.";

    public InvalidDuplicatedNamesException() {
        super(INVALID_DUPLICATED_NAMES_MESSAGE);
    }
}
