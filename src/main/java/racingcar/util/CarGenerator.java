package racingcar.util;

import racingcar.Car;

public class CarGenerator {
    public static Car createCar(String name) {
        return new Car(name);
    }
}