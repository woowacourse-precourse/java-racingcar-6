package racingcar.model;

import static racingcar.util.Constant.FORWARD_THRESHOLD;
import static racingcar.util.Constant.MAX_CAR_NAME_LENGTH;

import racingcar.exception.car.NotValidNameLengthException;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class Car implements Vehicle {

    private final String name;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(final String name) {
        if (isNameLengthValid(name)) {
            throw new NotValidNameLengthException(name);
        }
    }

    private boolean isNameLengthValid(final String name) {
        return name.length() < MAX_CAR_NAME_LENGTH.getValue();
    }

    @Override
    public boolean canMove() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return numberGenerator.generateNumber() >= FORWARD_THRESHOLD.getValue();
    }

    public String getName() {
        return name;
    }
}
