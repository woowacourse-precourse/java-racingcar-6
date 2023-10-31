package racingcar.domain;

import java.util.List;

import static racingcar.enums.RacingConfig.MIN_CAR_COUNT;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicatedCar(cars);
        validateSize(cars);
        this.cars = cars;
    }

    private void validateDuplicatedCar(List<Car> cars) {
        long distinctCount = cars.stream()
                .distinct()
                .count();
        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format("자동차는 %d대 이상이어야 합니다.", MIN_CAR_COUNT.getValue()));
        }
    }

    public int size() {
        return cars.size();
    }

    public Car findCar(int index) {
        return cars.get(index);
    }

    public int getMaxMovedCount() {
        return cars.stream()
                .mapToInt(Car::getMovedCount)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
