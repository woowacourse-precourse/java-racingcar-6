package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.CarConstant;

import static racingcar.constant.message.ExceptionMessage.INVALID_CAR_NAME_LENGTH_EXCEPTION_MESSAGE;

public class Car {

    private String name;
    private Integer distance = 0;

    public Car(String name) {
        if (isCorrectCarName(name)) {
            this.name = name;
        }
    }

    private Boolean isCorrectCarName(String name) {
        if (name.length() > CarConstant.NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public void stopOrMoveForward() {
        if (isMoveForward()) {
            this.moveForward();
        }
    }

    private Boolean isMoveForward() {
        if (Randoms
                .pickNumberInRange(CarConstant.STOP_OR_MOVE_RANDOM_START_RANGE, CarConstant.STOP_OR_MOVE_RANDOM_END_RANGE) < CarConstant.STOP_OR_MOVE_STANDARD_NUMBER) {
            return false;
        }
        return true;
    }

    private void moveForward() {
        this.distance++;
    }

    public String distanceConvertString() {
        return String.format("%s : ", this.name) + CarConstant.DISTANCE_PRINT_UNIT.repeat(this.distance);
    }

    public Integer measureDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }
}
