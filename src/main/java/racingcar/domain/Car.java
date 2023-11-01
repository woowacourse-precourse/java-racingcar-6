package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.Number;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);

        this.name = name;
        this.position = Number.INITIAL_POSITION;
    }

    public void forwardIfConditionMet(int forwardCondition) {
        if (forwardCondition >= Number.FORWARD_CONDITION_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void validate(String name) {
        checkCarNameEmpty(name);
        checkCarNameLengthValid(name);
        checkCarNameContainsWhiteSpace(name);
    }

    public void checkCarNameLengthValid(String carName) {
        if (carName.length() > Number.VALID_CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    public void checkCarNameEmpty(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_EMPTY_MESSAGE);
        }
    }

    public void checkCarNameContainsWhiteSpace(String carName) {
        if (carName.length() != carName.replace(" ", "").length()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_CONTAINS_WHITE_SPACE_MESSAGE);
        }
    }

}
