package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.dto.CarDTO;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private static final ArrayList<Car> cars = new ArrayList<>();
    private static final String EMPTY_CAR_MESSAGE = "등록된 자동차가 없습니다.";

    public void saveCar(Car car) {
        cars.add(car);
    }

    public List<Car> findCars() {
        return new ArrayList<>(cars);
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::toDTO)
                .mapToInt(CarDTO::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(EMPTY_CAR_MESSAGE));
    }
}
