package racingcar.repository;

import racingcar.Domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private static final CarRepository instance = new CarRepository();

    public static CarRepository getInstance() {
        return instance;
    }
    private List<Car> Cars = new ArrayList<>();

    public void save(String carName) {
        Cars.add(new Car(carName));
    }

    public List<Car> getCars() {
        return Cars;
    }
}
