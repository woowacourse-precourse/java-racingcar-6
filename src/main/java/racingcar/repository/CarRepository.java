package racingcar.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class CarRepository {

    private final static CarRepository instance = new CarRepository();

    private List<Car> carRepository = new ArrayList<>();

    private CarRepository() {

    }

    public static CarRepository getInstance() {
        return instance;
    }

    public void save(Car car) {
        carRepository.add(car);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(carRepository);
    }

}
