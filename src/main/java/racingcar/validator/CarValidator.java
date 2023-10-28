package racingcar.validator;

public class CarValidator implements Validator {
    private final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public void validate(String name) {
        if (isBlank(name) || isValidCarNameLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isValidCarNameLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }
}
