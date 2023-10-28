package racingcar.model;

import racingcar.vo.CarName;

public class Car {

    private static final Integer INIT_STEP = 0;

    private final CarName carName;
    private Integer step;

    public Car(final CarName carName) {
        this.carName = carName;
        this.step = INIT_STEP;
    }

    public void move() {
        this.step = Status.moveOrStop() + this.step;
    }

    public CarName getCarName() {
        return carName;
    }

    public Integer getStep() {
        return step;
    }
}