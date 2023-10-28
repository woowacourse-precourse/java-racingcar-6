package racingcar.domain;

import java.util.function.BooleanSupplier;

public class Car {
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
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
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
}
