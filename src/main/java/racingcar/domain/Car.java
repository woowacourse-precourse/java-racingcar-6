package racingcar.domain;

import racingcar.resource.CarGameValue;
import racingcar.util.RandomUtil;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (moveCheck()) {
            this.position++;
        }
    }

    private boolean moveCheck() {
        int randomNumber = RandomUtil.getRandomNumberRange(
                CarGameValue.CAR_MOVE_MIN_NUMBER.getValue(),
                CarGameValue.CAR_MOVE_MAX_NUMBER.getValue()
        );
        return randomNumber >= CarGameValue.CAR_MOVE_MORE_THAN_NUMBER.getValue();
    }
}
