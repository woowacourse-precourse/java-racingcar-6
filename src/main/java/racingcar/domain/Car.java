package racingcar.domain;

import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;

import racingcar.exception.RacingGameException;

public class Car {

    private static final Integer CAR_START_POSITION = 0;
    private static final Integer CAR_ONE_STEP = 1;
    private static final Integer CAR_CAN_GO_NUMBER = 4;
    private static final Integer CAR_LIMIT_NAME_LENGTH = 5;
    private final String name;
    private Integer position;

    private Car(String name) {
        this.name = name;
        this.position = CAR_START_POSITION;
    }

    public static Car from(final String name) {
        validate(name);

        return new Car(name);
    }

    private static void validate(String name) {
        if (isWrongLength(name)) {
            throw RacingGameException.of(INVALID_NAME_LENGTH);
        }

    }

    private static boolean isWrongLength(String name) {
        return name.isBlank() || name.length() > CAR_LIMIT_NAME_LENGTH;
    }

    public void go(final Integer randomNumber) {
        if (isAbleToGo(randomNumber)) {
            position += CAR_ONE_STEP;
        }

    }

    private static boolean isAbleToGo(Integer randomNumber) {
        return randomNumber >= CAR_CAN_GO_NUMBER;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public Boolean isHere(final Integer position) {
        return this.position.equals(position);
    }

}
