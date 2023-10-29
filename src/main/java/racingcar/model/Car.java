package racingcar.model;

import racingcar.constant.RacingGameConstants;
import racingcar.exception.NullException;
import racingcar.exception.car.name.LengthException;
import racingcar.utils.RandomGenerator;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        validateNull(name);
        validateNameLength(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new NullException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < RacingGameConstants.CAR_NAME_LENGTH_MIN
                || name.length() > RacingGameConstants.CAR_NAME_LENGTH_MAX) {
            throw new LengthException();
        }
    }

    public void TryToMove() {
        int randomNumber = RandomGenerator
                .generateRandomIntInRange(RacingGameConstants.MOVE_ENERGY_MIN, RacingGameConstants.MOVE_ENERGY_MAX);

        if(randomNumber >= RacingGameConstants.ENERGY_THRESHOLD_TO_MOVE) {
            moveOneStep();
        }
    }

    public void moveOneStep() {
        position++;
    }
}
