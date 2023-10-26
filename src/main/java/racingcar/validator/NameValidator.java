package racingcar.validator;

public class NameValidator implements Validator {

    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String name) {
        throwIfIsEmpty(name);
        throwIfExceedMaximumLength(name);
    }

    private void throwIfIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void throwIfExceedMaximumLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
