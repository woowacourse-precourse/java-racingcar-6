package racingcar.model;

import java.util.List;

public class CarCollection {

    private final List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public CarCollection(List<Car> cars) {
        this.cars = cars;
    }

}
