package Car.impl;

import Car.Car;

public class CarImpl implements Car {
    private int movedDistance;
    public CarImpl() {
        movedDistance = 0;
    }

    @Override
    public void move() {
        movedDistance += 1;
    }

    @Override
    public int getMovedDistance() {
        return this.movedDistance;
    }
}
