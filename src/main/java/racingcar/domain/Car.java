package racingcar.domain;

import java.util.function.BooleanSupplier;

public class Car implements Comparable<Car> {
    public static final String NOT_BLANK_NAME = "자동차 이름은 비어있을 수 없습니다";
    public static final String INVALID_NAME_LENGTH_FORMAT = "자동차 이름은 %d자 이하여야 합니다";
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final BooleanSupplier engine;
    private int position;

    public Car(String name) {
        this(name, new DefaultEngine());
    }

    public Car(String name, BooleanSupplier engine) {
        validateName(name);
        this.name = name;
        this.engine = engine;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_FORMAT, MAX_NAME_LENGTH));
        }
    }

    public void moveForward() {
        if (engine.getAsBoolean()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.position;
    }
}
