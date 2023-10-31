package racingcar.model;

import static racingcar.error.ErrorMessage.LONG_CAR_NAME;

public class Car {

    private static final int BOUND = 4;

    private final String name;
    private int forwardCount;

    public Car(final String name) {
        this.name = regulateName(name);
        this.forwardCount = 0;
    }

    public Car(final String name, final int forwardCount) {
        this.name = regulateName(name);
        this.forwardCount = forwardCount;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward(final int value) {
        if (isMovable(value)) {
            this.forwardCount++;
        }
    }

    private boolean isMovable(final int value) {
        return value >= BOUND;
    }

    private String regulateName(final String name) {
        final String trimmedName = name.trim();

        if (name.length() > 5) {
            throw new IllegalArgumentException(LONG_CAR_NAME.getMessage());
        }

        return trimmedName;
    }
}
