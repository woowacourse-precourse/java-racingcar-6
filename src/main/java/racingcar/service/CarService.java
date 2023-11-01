package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.dto.CarDTO;

public class CarService {

    private static final ArrayList<Car> cars = new ArrayList<>();

    public void saveCar(Car car) {
        cars.add(car);
    }

    public List<Car> findCars() {
        return new ArrayList<>(cars);
    }

    public int getMaxMoveCount() {
        return cars.stream()
                .map(Car::toDTO)
                .mapToInt(CarDTO::getMoveCount)
                .max().orElseThrow(IllegalStateException::new);
    }
}