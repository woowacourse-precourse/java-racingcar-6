package racingcar.domain.car;

import racingcar.domain.numberpicker.RandomNumberPicker;

public class Car {

    private static final int MIN_REQUIRED_DIGIT_TO_MOVE_FORWARD = 4;

    private final CarName name;
    private final ForwardCount forwardCount;

    private Car(CarName name, ForwardCount forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public static Car nameOf(CarName name) {
        return new Car(name, ForwardCount.defaultOf());
    }

    public void moveForward(RandomNumberPicker randomNumberPicker) {
        if (randomNumberPicker.pickOneDigit() >= MIN_REQUIRED_DIGIT_TO_MOVE_FORWARD) {
            this.forwardCount.increaseByOne();
        }
    }

    public long getForwardCount() {
        return this.forwardCount.getCount();
    }

}
