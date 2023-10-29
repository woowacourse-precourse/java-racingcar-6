package racingcar.domain;

import racingcar.vo.CarName;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

}
