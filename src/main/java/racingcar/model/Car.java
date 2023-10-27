package racingcar.model;

import static racingcar.util.Constant.FORWARD_THRESHOLD;

import racingcar.util.NumberGenerator;

public class Car implements Vehicle {

    private final CarName carName;

    private Car(final CarName carName) {
        this.carName = carName;
    }

    public static Car createWith(final CarName carName) {
        return new Car(carName);
    }

    @Override
    public boolean canMove(final NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= FORWARD_THRESHOLD.getValue();
    }

    public String getName() {
        return carName.getName();
    }
}
