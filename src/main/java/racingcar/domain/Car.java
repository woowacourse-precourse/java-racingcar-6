package racingcar.domain;

import java.util.HashMap;

public class Car {

    private HashMap<String, Integer> car;

    public Car(HashMap<String, Integer> car) {
        this.car = car;
    }

    public Car(String carName) {
        car.put(carName, 0);
    }

    public void setMovingCount(String carName) {
        car.put(carName, getMovingCount(carName) + 1);
    }

    private int getMovingCount(String carName) {
        return car.get(carName);
    }

}
