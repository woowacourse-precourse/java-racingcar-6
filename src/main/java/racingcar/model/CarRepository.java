package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();
    private final static int CAR_CAPACITY = 100;

    public void save(final Car car) {
        validateCapacity();
        validateDuplicateName(car.getName());
        this.cars.add(car);
    }

    private void validateDuplicateName(final String carName) {
        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    private void validateCapacity() {
        if (this.cars.size() >= CAR_CAPACITY) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MAX_CAR_COUNT.getMessage());
        }
    }

    public final List<Car> getCars() {
        return cars;
    }

    public final List<String> getWinner() {
        int max = getMaxPosition();
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
