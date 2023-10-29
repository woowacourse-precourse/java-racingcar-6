package racingcar.model;

import racingcar.model.wrapper.CarName;

public class Car {
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        position = 0;
    }

    public void move() {
        position++;
    }

    public void move(int power) {
        if (isMovablePower(power)) {
            move();
        }
    }

    public boolean isMovablePower(int power) {
        return power >= 4;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
