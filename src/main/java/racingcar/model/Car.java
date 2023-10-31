package racingcar.model;

import racingcar.constant.Error;
import racingcar.constant.NumberConstant;

public class Car {

    private final int START_POSITION = 0;
    private final int STEP_SIZE = 1;
    private final String name;
    private int position = START_POSITION;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.name = carName;
    }

    public void addPosition() {
        position += STEP_SIZE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarNameLength(String carName) {
        if (!isCarNameLengthInRange(carName)) {
            throw new IllegalArgumentException(Error.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    private boolean isCarNameLengthInRange(String carName) {
        return carName.length() <= NumberConstant.MAX_CAR_NAME_LENGTH
                && carName.length() != NumberConstant.MIN_CAR_NAME_LENGTH;
    }
}
