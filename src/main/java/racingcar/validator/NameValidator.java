package racingcar.validator;

public class NameValidator implements Validator {

    private static final String ERROR_EMPTY_NAME = "비어있는 이름이 있습니다.";
    private static final String ERROR_MAX_NAME_LENGTH_EXCEED = "이름은 최대 5글자 입니다.";

    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String name) {
        throwIfIsEmpty(name);
        throwIfExceedMaximumLength(name);
    }

    private void throwIfIsEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private void throwIfExceedMaximumLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MAX_NAME_LENGTH_EXCEED);
        }
    }
}
