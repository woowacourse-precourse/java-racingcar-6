package racingcar.domain;

import java.util.function.BooleanSupplier;

public class Car {
    private final BooleanSupplier engine;
    private int position;

    public Car(BooleanSupplier engine) {
        this.engine = engine;
        this.position = 0;
    }

    public void moveForward() {
        if (engine.getAsBoolean()) {
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }
}
