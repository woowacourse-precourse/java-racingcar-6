package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.CarNamesInputErrorMessage;
import racingcar.constant.Constant;

public class Car {
    private String name;
    private Long distance;

    public Car(String name) {
        validateNameRange(name);
        this.name = name;
        this.distance = Constant.CAR_INIT_DISTANCE_VALUE;
    }

    private void validateNameRange(String name) {
        if (name.length() > Constant.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_LENGTH_EXCEEDS_LIMIT);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
        }
    }

    public void moveOrStop() {
        int randomValue = Randoms.pickNumberInRange(Constant.RANDOM_VALUE_LOWER_LIMIT,
                Constant.RANDOM_VALUE_UPPER_LIMIT);
        if (randomValue >= Constant.MOVE_OR_STOP_BOUNDARY_VALUE && randomValue < Constant.RANDOM_VALUE_UPPER_LIMIT) {
            move();
            return;
        }
        if (randomValue < Constant.MOVE_OR_STOP_BOUNDARY_VALUE && randomValue >= Constant.RANDOM_VALUE_LOWER_LIMIT) {
            stop();
        }
    }

    private void move() {
        distance++;
    }

    private void stop() {

    }

    public String getName() {
        return this.name;
    }

    public Long getDistance() {
        return this.distance;
    }
}