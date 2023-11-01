package racingcar.domain;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> cars;

    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(ArrayList<Car> cars) {
        return new Cars(cars);
    }
}
