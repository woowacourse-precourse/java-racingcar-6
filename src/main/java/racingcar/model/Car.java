package racingcar.model;

import static racingcar.exception.ExceptionMessage.CAR_NAME_CANNOT_EXCEED_MAX_LENGTH;

public class Car {
    private static final int INITIAL_CAR_POSITION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;
    private int position;

    private Car(String name) {
        validate(name);

        this.name = name;
        this.position = INITIAL_CAR_POSITION;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    private void validate(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_EXCEED_MAX_LENGTH);
        }
    }

    private boolean isInvalidNameLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }

    public void move() {
        setPosition(this.position + 1);
    }

    private void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
