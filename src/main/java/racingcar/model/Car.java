package racingcar.model;

import racingcar.constant.Error;
import racingcar.constant.NumberConstant;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.name = carName;
    }

    public void addPosition() {
        position += 1;
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
