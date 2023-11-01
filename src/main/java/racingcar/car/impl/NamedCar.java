package racingcar.car.impl;

import racingcar.car.Car;

public class NamedCar implements Car {
    private int movedDistance;
    private final String name;
    public NamedCar(String name) {
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

    @Override
    public void printProcess() {
        System.out.print(name + " : ");
        for (int i = 0 ; i < movedDistance ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
