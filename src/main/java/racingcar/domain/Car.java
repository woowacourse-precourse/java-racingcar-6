package racingcar.domain;

import racingcar.view.InputView;

import java.util.List;

public class Car {
    private final String name;
    private int position;

    public static Car createCar(String name) {
        return new Car(name);
    }
    private Car(String name) {
        this.name = name;
        this.position = 0;
    }


}
