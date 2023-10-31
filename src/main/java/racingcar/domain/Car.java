package racingcar.domain;

import java.util.List;

import static racingcar.domain.InputCarValidator.*;


public class Car {
    private String name;

    Car(String name) {
        this.name = name;
    }

    public static Car createCar(String name) {
        checkOver5Letters(name);
        checkCarWithBlank(name);
        return new Car(name);
    }

    public String carInfo() {
        return this.name;
    }
}
