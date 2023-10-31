package racingcar.domain;

import static racingcar.consts.GameConstant.MIN_FORWARD_THRESHOLD;
import static racingcar.consts.ViewConstant.DISTANCE_MESSAGE;
import static racingcar.consts.ViewConstant.DIVISION_MESSAGE;

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
        if (RandomGenerator.generate() >= MIN_FORWARD_THRESHOLD.get()) {
            this.addDistance();
        }
    }

    @Override
    public String toString() {
        return this.name + DIVISION_MESSAGE.get() + DISTANCE_MESSAGE.get()
                .repeat(totalDistance);
    }
}
