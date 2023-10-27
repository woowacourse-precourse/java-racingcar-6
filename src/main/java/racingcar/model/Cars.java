package racingcar.model;

import static racingcar.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateEachCarUnique(cars);
        this.cars = cars;
    }

    public static Cars from(final String names) {
        List<Name> carNames = Name.createCarNames(names);
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }

    public void racing(final RandomNumber randomNumber) {
        cars.forEach(car -> {
            int number = randomNumber.pickNumber();
            car.accelerate(number);
        });
    }

    public List<String> eachStatus() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    public List<String> collectWinners(final int gameCount) {
        return cars.stream()
                .filter(car -> car.isWinner(gameCount))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateEachCarUnique(final List<Car> cars) {
        List<Car> uniqueCars = cars.stream()
                .distinct()
                .toList();

        if (uniqueCars.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.toString());
        }
    }
}
