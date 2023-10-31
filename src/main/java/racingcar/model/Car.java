package racingcar.model;

import static racingcar.error.ErrorMessage.LONG_CAR_NAME;

public class Car {

    private static final int BOUND = 4;

    private final String name;
    private int forwardCount;

    public Car(final String name) {
        final String trimmedName = name.trim();

        validateName(trimmedName);

        this.name = trimmedName;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward(final int value) {
        if (isMovable(value)) {
            this.forwardCount ++;
        }
    }

    private boolean isMovable(final int value) {
        return value >= BOUND;
    }

    private void validateName(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(LONG_CAR_NAME.getMessage());
        }
    }
}
