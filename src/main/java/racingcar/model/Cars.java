package racingcar.model;

import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateEachCarUnique(cars);
        this.cars = cars;
    }

    private void validateEachCarUnique(final List<Car> cars) {
        List<Car> uniqueCars = cars.stream()
                .distinct()
                .toList();

        if (uniqueCars.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public static Cars from(final String names) {
        List<Name> carNames = Name.createCarNames(names);
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }

    public void race(final RandomNumber randomNumber) {
        cars.forEach(car -> {
            int number = randomNumber.pickNumber();
            car.accelerate(number);
        });
    }

    public List<String> collectEachStatus() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public List<String> collectWinners() {
        int highestPosition = getHighestPosition();
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(highestPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getHighestPosition() {
        int position = DEFAULT_POSITION;
        for (Car car : cars) {
            position = Math.max(car.getPosition(), position);
        }
        return position;
    }

    public boolean isCarsCountEqualTo(final int size) {
        return cars.size() == size;
    }
}
