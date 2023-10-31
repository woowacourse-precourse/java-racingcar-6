package racingcar.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class CarData {
    private final List<Car> carFactory = new ArrayList<>();
    private final Map<String, Car> indexCarByName = new HashMap<>();

    public void addAll(List<Car> carList) {
        carFactory.addAll(carList);
        indexCarByName.putAll((Map<? extends String, ? extends Car>) carFactory.stream()
                .map(car -> Map.of(car.getName(), car))
                .toList());
    }

    public int getCountMax() {
        return carFactory.stream()
                .mapToInt(Car::getProgress)
                .max()
                .getAsInt();
    }

    public List<Car> findAllByProgress(int maxProgress) {
        return carFactory.stream()
                .filter(car -> car.sameProgress(maxProgress))
                .map(Car::getCar)
                .toList();
    }

    public List<Car> findAll() {
        return carFactory.stream()
                .map(Car::getCar)
                .toList();
    }

    public List<Car> updateAll(List<Car> findCars) {
        for (Car findCar : findCars) {
            Car car = indexCarByName.get(findCar.getName());
            car.updateProgress(car.getProgress());
        }
        return findAll();
    }

}
