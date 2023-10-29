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
        if (carRepository.contains(car)) {
            update(car);
            return;
        }

        carRepository.add(car);
    }

    public void update(Car car) {
        int previousIndex = carRepository.indexOf(car);
        carRepository.set(previousIndex, car);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(carRepository);
    }

    public void updateAll(List<Car> cars) {
        cars.forEach(this::update);
    }

}
