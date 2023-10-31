package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    List<Car> cars = new ArrayList<>();
    private static final int startBoost = 0;
    String carName;
    int carBoost;

    public Car(String carName) {
        this.carName = carName;
        carBoost = startBoost;
    }

    void setCarRandomNumbers(List<Integer> carBoost) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).carBoost += carBoost.get(i);
        }
    }

    public void add(Car car) {
        this.cars.add(car);
    }

}
