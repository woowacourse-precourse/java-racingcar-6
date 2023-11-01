package racingcar.domain;

import static java.lang.String.format;
import static racingcar.constant.ErrorMessage.EMPTY_INPUT_ERROR;
import static racingcar.constant.ErrorMessage.LENGTH_INPUT_ERROR;
import static racingcar.constant.RaceSetting.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.RaceSetting.MIN_MOVE_NUMBER;
import static racingcar.constant.RaceSetting.MOVE_NUMBER;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validationName(name);
        this.name = name;
        this.distance = 0;
    }

    private void validationName(String name) {
        validateEmptyInput(name);
        validateLengthInput(name);
    }

    private void validateEmptyInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }

    private void validateLengthInput(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(
                    format(LENGTH_INPUT_ERROR.getMessage(), MAX_CAR_NAME_LENGTH.getValue())
            );
        }
    }

    public void run(int number) {
        if (move(number)) {
            distance += MOVE_NUMBER.getValue();
        }
    }

    private boolean move(int number) {
        return number >= MIN_MOVE_NUMBER.getValue();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
