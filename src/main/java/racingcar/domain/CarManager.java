package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.exception.ExceptionMsg.INVALID_DUPLICATE_NAME;

public class CarManager {

    private static final String DELIMITER = ", ";
    private final List<Car> cars;


    public CarManager(List<Car> cars) {
        validateCars(cars);

        this.cars = cars;
    }

    public String moveCar(RaceRule raceRule) {
        cars.stream()
                .filter(car -> raceRule.isMove())
                .forEach(Car::moveForward);

        return cars.stream().map(Car::getCarStatus)
                .collect(Collectors.joining("\n"));
    }


    public String getWinner() {
        int maxMove = cars.stream().max(Comparator.comparing(Car::getMove))
                .get().getMove();

        return cars.stream()
                .filter(car -> car.getMove() == maxMove)
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private static void validateCars(List<Car> cars) {
        long count = cars.stream().distinct().count();

        if (count != cars.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NAME.getMessage());
        }
    }
}
