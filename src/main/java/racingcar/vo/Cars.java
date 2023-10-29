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
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::toDTO)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}
