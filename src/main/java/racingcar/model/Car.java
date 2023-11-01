package racingcar.model;

import racingcar.constant.ForwardInfoConstant;
import racingcar.util.RandomUtil;

public class Car {
    private final String name;
    private Integer forwards;

    public Car(String name) {
        this.name = name;
        this.forwards = 0;
    }

    public void moveForward() {
        int randomNumber = RandomUtil.createRandomNumberInRange(ForwardInfoConstant.MIN_RANDOM_NUMBER.getValue(), ForwardInfoConstant.MAX_RANDOM_NUMBER.getValue());
        if (randomNumber >= ForwardInfoConstant.REFERENCE_VALUE_MOVING_FORWARD.getValue()) {
            this.forwards++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getForwards() {
        return this.forwards;
    }
}
