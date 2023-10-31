package racingcar.domain;

import java.util.HashMap;
import java.util.Set;

public class Car {

    private HashMap<String, Integer> car;

    public Car(HashMap<String, Integer> car) {
        this.car = car;
    }

    public Set<String> getCarName() {
        return car.keySet();
    }

    public void setMovingCount(String carName) {
        car.put(carName, getMovingCount(carName) + 1);
    }

    public int getMovingCount(String carName) {
        return car.get(carName);
    }

}
