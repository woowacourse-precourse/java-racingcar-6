package racingcar.model;

import racingcar.enums.Common;
import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomGenerator;

public class Car {
    private static final int MAX_MOVE_DISTANCE = 1;
    private final String name;
    private Integer distance;

    public Car(String name) {
        validateCarNameInput(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForwardByRandom() { // TODO:
        NumberGenerator randomGenerator = new RandomGenerator();
        int randomNumber = randomGenerator.generateNumber(Common.MIN_NUMBER.getIntValue(), Common.MAX_NUMBER.getIntValue());
        if (randomNumber >= Common.STANDARD_NUMBER.getIntValue())
            distance += MAX_MOVE_DISTANCE;
    }

    private void validateCarNameInput(String carName) {
        if (carName == null)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
        if (carName.isBlank())
            throw new IllegalArgumentException(ErrorMessages.EMPTY_ERROR.getMessage());
        if (CommonValidator.isStringOverLength(carName, Common.STANDARD_NUMBER.getIntValue()))
            throw new IllegalArgumentException(ErrorMessages.OVER_LENGTH_ERROR.getMessage());
        if (carName.contains(Common.SEPARATOR.getStringValue()))
            throw new IllegalArgumentException(ErrorMessages.SEPARATOR_ERROR.getMessage());
    }
}
