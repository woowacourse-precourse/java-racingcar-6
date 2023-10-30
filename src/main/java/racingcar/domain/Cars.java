package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public void add(String name) {
        cars.add(new Car(name));
    }

    public int size() {
        return cars.size();
    }
}
