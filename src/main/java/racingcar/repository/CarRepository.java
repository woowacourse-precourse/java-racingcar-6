package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static CarRepository instance;
    private List<Car> carList = new ArrayList<>();

    private CarRepository() {
    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    public void add(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
