package racingcar;

import static racingcar.constant.Constant.COLON;

public abstract class Car {
    private String name;
    private String distanceDriver;

    public abstract void moveCar();

    @Override
    public String toString() {
        return name + COLON +distanceDriver;
    }
}
