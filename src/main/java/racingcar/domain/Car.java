package racingcar.domain;

import racingcar.util.RandomMoving;

public class Car {
    private final CarName carName;
    private int position = 0;
    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public void progress(RandomMoving movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}
