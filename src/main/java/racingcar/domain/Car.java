package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameConstant;
import racingcar.constant.message.CarGenerationErrorMessage;
import racingcar.constant.message.CarNamesInputErrorMessage;

public class Car {
    private final String name;
    private Long distance;

    public Car(String name) {
        validateNameRange(name);
        this.name = name;
        this.distance = GameConstant.CAR_INIT_DISTANCE_VALUE;
    }

    private void validateNameRange(String name) {
        isLengthUnderMaxLength(name);
        isEmpty(name);
    }

    private void isLengthUnderMaxLength(String name) {
        if (name.length() > GameConstant.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_LENGTH_EXCEEDS_LIMIT);
        }
    }

    private void isEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
        }
    }

    public void moveOrStop() {
        int randomValue = makeRandomValue();
        if (randomValue >= GameConstant.MOVE_OR_STOP_BOUNDARY_VALUE
                && randomValue <= GameConstant.RANDOM_VALUE_UPPER_LIMIT) {
            move();
            return;
        }
        if (randomValue < GameConstant.MOVE_OR_STOP_BOUNDARY_VALUE
                && randomValue >= GameConstant.RANDOM_VALUE_LOWER_LIMIT) {
            stop();
            return;
        }
        throw new IllegalArgumentException(CarGenerationErrorMessage.RANDOM_VALUE_NOT_IN_APPROPRIATE_RANGE);
    }

    private int makeRandomValue() {
        return Randoms.pickNumberInRange(GameConstant.RANDOM_VALUE_LOWER_LIMIT,
                GameConstant.RANDOM_VALUE_UPPER_LIMIT);
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