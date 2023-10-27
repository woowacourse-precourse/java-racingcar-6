package racingcar.model;

import static racingcar.util.Constant.FORWARD_THRESHOLD;

import java.util.Objects;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car implements Vehicle {

    private final CarName carName;

    private Car(final CarName carName) {
        this.carName = carName;
    }

    public static Car createWith(final CarName carName) {
        return new Car(carName);
    }

    @Override
    public boolean canMove() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return numberGenerator.generateNumber() >= FORWARD_THRESHOLD.getValue();
    }

    @Override
    public String getName() {
        return carName.getName();
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
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
