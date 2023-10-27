package racingcar.model;

import static racingcar.util.Constant.FORWARD_THRESHOLD;
import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;

import java.util.Objects;
import racingcar.exception.car.NotValidNameLengthException;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car implements Vehicle {

    private final String name;

    private Car(final String name) {
        this.name = name;
    }

    public static Car createWith(final String name) {
        validateCarName(name);
        return new Car(name);
    }

    private static void validateCarName(final String name) {
        if (!isNameLengthValid(name)) {
            throw new NotValidNameLengthException(name);
        }
    }

    private static boolean isNameLengthValid(final String name) {
        return name.length() < MAX_CAR_NAME_LENGTH.getValue();
    }

    @Override
    public boolean canMove() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return numberGenerator.generateNumber() >= FORWARD_THRESHOLD.getValue();
    }

    @Override
    public String getName() {
        return name;
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
