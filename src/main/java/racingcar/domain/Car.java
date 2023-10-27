package racingcar.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private final CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = Objects.requireNonNull(name);
        this.position = Objects.requireNonNull(position);
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), CarPosition.create());
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
