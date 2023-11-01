package racingcar.car.impl;

import racingcar.car.Car;

public class CarImpl implements Car {
    private int movedDistance;
    private final String name;
    public CarImpl(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    @Override
    public void move() {
        movedDistance += 1;
    }

    @Override
    public int getMovedDistance() {
        return this.movedDistance;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
