package racingcar.service.domain;

import java.util.Objects;

public class Car {
    private static final int CAN_MOVE_MIN_CONDITION = 4;
    private final CarName name;
    private final CarEngine carEngine;
    private int position;

    public Car(String name, CarEngine carEngine) {
        this.name = new CarName(name);
        this.carEngine = carEngine;
    }

    public void move() {
        int power = startEngine();
        if (canMove(power)) {
            position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    private int startEngine() {
        return carEngine.generateNumber();
    }

    private boolean canMove(int power) {
        return power >= CAN_MOVE_MIN_CONDITION;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
