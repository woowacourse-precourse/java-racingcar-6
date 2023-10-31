package racingcar.domain;

import java.util.List;
import java.util.Objects;
import racingcar.domain.car.Car;

public class Racing {

    private static final int MIN_COUNT_OF_CARS = 2;

    private final List<Car> cars;

    Racing(List<Car> cars) {
        validate(cars);
        this.cars = Objects.requireNonNull(cars);
    }

    private void validate(List<Car> cars) {
        if (isNotValidateSize(cars)) {
            String exceptionMessage = "레이싱에 참여하는 차는 최소 %d대 이상이어야 합니다".formatted(MIN_COUNT_OF_CARS);
            throw new IllegalArgumentException(exceptionMessage);
        }
        if (isOverlappedName(cars)) {
            throw new IllegalArgumentException("레이싱에 참여하는 차 이름이 겹치면 안됩니다");
        }
    }

    private boolean isNotValidateSize(List<Car> cars) {
        return cars.size() < MIN_COUNT_OF_CARS;
    }

    private boolean isOverlappedName(List<Car> cars) {
        int countOfDistinctCars = (int) cars.stream().map(Car::getName).distinct().count();
        return cars.size() != countOfDistinctCars;
    }

    public static Racing from(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::from).toList();
        return new Racing(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> findWinnersName() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();

        return cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
