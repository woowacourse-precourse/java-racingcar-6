package racingcar.domain.car;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Car {

    private final CarName name;
    private final CarPosition position;
    private final BooleanSupplier movingStrategy;

    Car(CarName name, CarPosition position, BooleanSupplier movingStrategy) {
        this.name = Objects.requireNonNull(name);
        this.position = Objects.requireNonNull(position);
        this.movingStrategy = Objects.requireNonNull(movingStrategy);
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), CarPosition.create(), CarRandomMovingStrategy.create());
    }

    public void move() {
        if (movingStrategy.getAsBoolean()) {
            position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
