package racingcar.domain.car.dao;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarRepository {

    private static Long CarId = 0L;
    private HashMap<Long, Car> carDatabase = new HashMap<>();

    public void save(Car car) {
        carDatabase.put(CarId, car);
        CarId++;
    }

    public List<Car> findAll() {
        ArrayList<Car> cars = new ArrayList<>();
        carDatabase.forEach((carId, car) -> cars.add(car));
        return cars;
    }

    public List<Car> findCarWithMaxPosition() {
        int maxPosition = carDatabase.values()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        ArrayList<Car> winners = new ArrayList<>();
        return carDatabase.values()
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
