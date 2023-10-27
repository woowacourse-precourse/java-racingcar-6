package racingcar;

public class RacingCar {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNameLengthInRange(name);
    }

    private void validateNameLengthInRange(String name) {
        validateNameLengthLongerThanMinimumValue(name);
        validateNameLengthShorterThanMaximumValue(name);
    }

    private void validateNameLengthShorterThanMaximumValue(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLengthLongerThanMinimumValue(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
