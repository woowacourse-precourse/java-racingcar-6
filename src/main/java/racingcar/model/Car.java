package racingcar.model;

import racingcar.enums.Common;
import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomGenerator;

public class Car {
    private static final int MAX_MOVE_DISTANCE = 1;
    private static final int INITIAL_DISTANCE = 0;
    private final String name;
    private Integer distance;

    public Car(String name) {
        validateCarNameInput(name);
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForwardByRandom() {
        NumberGenerator randomGenerator = new RandomGenerator();
        int randomNumber = randomGenerator.generateNumber();
        if (randomNumber >= Common.STANDARD_NUMBER.getIntValue())
            distance += MAX_MOVE_DISTANCE;
    }

    private void validateCarNameInput(String carName) {
        if (carName == null)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
        if (carName.isBlank())
            throw new IllegalArgumentException(ErrorMessages.EMPTY_ERROR.getMessage());
        if (CommonValidator.isStringOverLength(carName, Common.CAR_NAME_MAX_LENGTH.getIntValue()))
            throw new IllegalArgumentException(ErrorMessages.OVER_LENGTH_ERROR.getMessage());
        if (carName.contains(Common.SEPARATOR.getStringValue()))
            throw new IllegalArgumentException(ErrorMessages.SEPARATOR_ERROR.getMessage());
    }
}
