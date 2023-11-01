package racingcar.vo;

import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDTO;

public class Cars {
    private static final int MINIMUM_CARS_SIZE = 2;
    private static final String MINIMUM_CARS_ERROR_MESSAGE = "자동차는 2대 이상이어야 합니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarsSize(cars);
        this.cars = cars;
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() < MINIMUM_CARS_SIZE) {
            throw new IllegalArgumentException(MINIMUM_CARS_ERROR_MESSAGE);
        }
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<CarDTO> toDTO() {
        return cars.stream().map(Car::toDTO).toList();
    }

    public List<CarDTO> getMaxPositionCars() {
        Car maxCar = getMaxCar();
        return cars.stream()
                .filter(maxCar::isSamePosition)
                .map(Car::toDTO)
                .toList();
    }

    private Car getMaxCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }
}
