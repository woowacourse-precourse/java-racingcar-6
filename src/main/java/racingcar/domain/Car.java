package racingcar.domain;

import static racingcar.exception.ErrorMessage.BLANK_NAME;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;

import racingcar.exception.RacingGameException;

public class Car {

    private static final int CAR_START_POSITION = 0;
    private static final int CAR_ONE_STEP = 1;
    private static final int CAR_CAN_GO_NUMBER = 4;
    private static final int CAR_LIMIT_NAME_LENGTH = 5;
    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = CAR_START_POSITION;
    }

    public static Car from(final String name) {
        validate(name);

        return new Car(name);
    }

    private static void validate(final String name) {
        if (name.isBlank()) {
            throw RacingGameException.of(BLANK_NAME);
        }

        if (name.length() > CAR_LIMIT_NAME_LENGTH) {
            throw RacingGameException.of(INVALID_NAME_LENGTH);
        }

    }

    public void go(int randomNumber) {
        if (isAbleToGo(randomNumber)) {
            position += CAR_ONE_STEP;
        }

    }

    private static boolean isAbleToGo(int randomNumber) {
        return randomNumber >= CAR_CAN_GO_NUMBER;
    }

    public Boolean isHere(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }


}
