package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

public class Car {
    private final CarName name;
    private CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), CarPosition.zero());
    }

    public void move(MovingStrategy movingStrategy) {
        position = position.move(movingStrategy);
    }

    public String nameValue() {
        return name.value();
    }

    public int positionValue() {
        return position.value();
    }
}
