package racingcar.domain;

import static racingcar.domain.InputCarValidator.checkCarWithBlank;
import static racingcar.domain.InputCarValidator.checkOver5Letters;


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
