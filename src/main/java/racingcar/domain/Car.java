package racingcar.domain;

import static racingcar.constant.RacingGameConstant.CAR_CAN_GO_NUMBER;
import static racingcar.constant.RacingGameConstant.CAR_LIMIT_NAME_LENGTH;
import static racingcar.constant.RacingGameConstant.CAR_ONE_STEP;
import static racingcar.constant.RacingGameConstant.CAR_START_POSITION;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;

import racingcar.exception.RacingGameException;

public class Car {


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
        return name.length() > CAR_LIMIT_NAME_LENGTH || name.isBlank();
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
