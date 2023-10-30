package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Cars {
    Map<String, Car> cars = new HashMap<>();

    public void addList(String name) {
        cars.put(name, new Car(name, 0));
    }


}
