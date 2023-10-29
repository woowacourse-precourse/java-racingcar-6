package racingcar.domain;

import static racingcar.domain.GameOption.CAR_POSITION_SIGN;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(int position) {
        return this.position.getAmount() == position;
    }

    public void moveForward() {
        position.increment();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getAmount();
    }

    @Override
    public String toString() {
        return name.getName() + " : " + CAR_POSITION_SIGN.repeat(position.getAmount());
    }
}
