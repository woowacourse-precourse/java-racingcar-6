package racingcar.domain;

import java.util.*;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

}
