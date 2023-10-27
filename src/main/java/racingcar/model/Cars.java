package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void add(String name) {
        Car car = new Car(name, "");
        cars.add(car);
    }
}
