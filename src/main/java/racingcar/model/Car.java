package racingcar.model;

import racingcar.dto.CarStatus;
import racingcar.util.RandomNumberUtil;

public class Car {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_RANDOM_VALUE = 0;
    private static final int MAXIMUM_RANDOM_VALUE = 9;
    private static final int MINIMUM_FORWARD_POSSIBLE_VALUE = 4;
    private static final int FORWARD_DISTANCE = 1;

    private final RandomNumberUtil randomNumberUtil;
    private final String name;

    private int position;

    public Car(RandomNumberUtil randomNumberUtil, String name, int position) {
        validationCarName(name);

        this.randomNumberUtil = randomNumberUtil;
        this.name = name;
        this.position = position;
    }

    private void validationCarName(String carName) {
        if (carName.isEmpty() || carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    public void forward() {
        if (isCarAbleToForward()) {
            position += FORWARD_DISTANCE;
        }
    }

    private boolean isCarAbleToForward() {
        int randomNumber = randomNumberUtil.generateNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
        return randomNumber >= MINIMUM_FORWARD_POSSIBLE_VALUE;
    }

    public CarStatus getStatus() {
        return new CarStatus(name, position);
    }
}
