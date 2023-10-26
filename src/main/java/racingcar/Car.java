package racingcar;

public record Car(String name) {
    private static final int MAX_NAME_LENGTH = 4;

    public Car {
        validateName(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
    }
}
