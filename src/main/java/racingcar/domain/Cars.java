package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    void add(String name) {
        cars.add(new Car(name));
    }
}
