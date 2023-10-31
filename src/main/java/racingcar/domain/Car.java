package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

public class Car {
    private final CarName name;
    private CarPosition position;

    Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(CarName.from(name), CarPosition.zero());
    }

    public void move(MovingStrategy movingStrategy) {
        position = position.move(movingStrategy);
    }

    public CarPosition biggerPosition(CarPosition otherPosition) {
        if (position.biggerThan(otherPosition)) {
            return position;
        }
        return otherPosition;
    }

    public boolean positionEquals(CarPosition otherPosition) {
        return position.equals(otherPosition);
    }

    public String nameValue() {
        return name.value();
    }

    public int positionValue() {
        return position.value();
    }
}
