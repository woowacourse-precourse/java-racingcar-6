package racingcar.model;

import racingcar.utils.RandomGenerator;

import java.util.Calendar;
import java.util.Objects;

public final class Car {
    private static final int MOVE_CONDITION = 4;
    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(Name.of(name), Position.startFromZero());
    }

    static Car ofWithPosition(String name, int position) {
        return new Car(Name.of(name), Position.of(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public Car move(RandomGenerator randomGenerator) {
        if (randomGenerator.getRandomNumber() >= MOVE_CONDITION) {
            return new Car(name, position.move());
        }
        return this;
    }
}
