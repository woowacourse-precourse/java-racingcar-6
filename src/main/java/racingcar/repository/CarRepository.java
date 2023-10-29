package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
