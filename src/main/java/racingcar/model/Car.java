package racingcar.model;

import java.util.List;

public class Car {
    public static List<Car> carList;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }
}
