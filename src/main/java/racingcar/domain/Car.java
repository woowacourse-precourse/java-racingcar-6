package racingcar.domain;

import racingcar.consts.GameConstant;
import racingcar.consts.ViewConstant;
import racingcar.util.RandomGenerator;

public class Car {
    private String name;
    private int totalDistance;

    public Car(String name) {
        this.name = name;
        this.totalDistance = 0;
    }

    public void addDistance() {
        ++this.totalDistance;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public String getName() {
        return name;
    }

    public void drive() {
        if (RandomGenerator.generate() >= GameConstant.MIN_FORWARD_THRESHOLD.get()) {
            this.addDistance();
        }
    }

    @Override
    public String toString() {
        return this.name + ViewConstant.DIVISION_MESSAGE.get() + ViewConstant.DISTANCE_MESSAGE.get()
                .repeat(totalDistance);
    }
}
