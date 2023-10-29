package racingcar.domain;

import racingcar.Error;

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
        if (!isStringLengthInRange(carName)) {
            throw new IllegalArgumentException(Error.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    private boolean isStringLengthInRange(String string) {
        return string.length() <= 5 && string.length() != 0;
    }
}
