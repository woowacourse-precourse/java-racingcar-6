package racingcar.domain;

import java.util.Arrays;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean isEquals(String ... carNames) {
        return Arrays.stream(carNames).anyMatch((carName) -> this.name.equals(carName));
    }
}
