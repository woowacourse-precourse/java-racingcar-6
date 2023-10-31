package racingcar.model;

import racingcar.enums.Common;
import racingcar.enums.ErrorMessages;
import racingcar.utils.CommonValidator;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomGenerator;

public class Car {
    private static final String DISTANCE_MARK = "-";
    private final String name;
    private final StringBuilder distance;

    public Car(String name) {
        validateCarNameInput(name);
        this.name = name;
        this.distance = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }

    public void moveForward() {
        NumberGenerator randomGenerator = new RandomGenerator();
        int randomNumber = randomGenerator.generateNumber(Common.MIN_NUMBER.getIntValue(), Common.MAX_NUMBER.getIntValue());
        if (randomNumber >= Common.STANDARD_NUMBER.getIntValue())
            distance.append(DISTANCE_MARK);
    }

    private void validateCarNameInput(String carName) {
        if (carName == null)
            throw new IllegalArgumentException(ErrorMessages.NULL_ERROR.getMessage());
        if (carName.isBlank())
            throw new IllegalArgumentException(ErrorMessages.EMPTY_ERROR.getMessage());
        if (CommonValidator.isOverMaxLength(carName))
            throw new IllegalArgumentException(ErrorMessages.OVER_LENGTH_ERROR.getMessage());
        if (carName.contains(Common.SEPARATOR.getStringValue()))
            throw new IllegalArgumentException(ErrorMessages.SEPARATOR_ERROR.getMessage());
    }
}
