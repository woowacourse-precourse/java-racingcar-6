package racingcar.car;

import racingcar.Constant;

public class Car {
    private String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void forward(int value) {
        if (value >= Constant.MINIMUM_MOVABLE_NUMBER) {
            position++;
        }
    }
}
