package racingcar.domain;

import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameNumberLimitException;

public class Car {
    public static final int CAR_NAME_NUMBERS_LIMIT_SIZE = 5;

    private String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car createCar(String name) {
        checkOver5Letters(name);
        checkCarWithBlank(name);
        return new Car(name);
    }

    public static void checkOver5Letters(String name) {
        if (name.length() > CAR_NAME_NUMBERS_LIMIT_SIZE) {
            throw new CarNameNumberLimitException();
        }

    }

    public static void checkCarWithBlank(String name) {
        if (name.isBlank()) {
            throw new BlankCarNameException();
        }
    }
}
