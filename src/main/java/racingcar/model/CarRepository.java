package racingcar.model;

import java.util.List;

public class CarRepository {
    private List<Car> cars;
    public void saveAll(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findAll() {
        return cars;
    }
}

