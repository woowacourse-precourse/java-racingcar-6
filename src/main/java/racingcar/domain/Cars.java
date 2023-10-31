package racingcar.domain;

import static racingcar.global.constants.NumberType.MIN_CAR_SIZE;
import static racingcar.global.constants.SymbolType.NEW_LINE;
import static racingcar.global.exception.ErrorMessage.DUPLICATE_NAME;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_LIST_SIZE;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.global.exception.RaceException;
import racingcar.utils.Parser;

public class Cars {
    private List<Car> cars;

    private Cars(final String userInput) {
        List<Car> cars = Parser.parseStringToCarList(userInput);
        Validator.validateCars(cars);
        this.cars = cars;
    }

    public static Cars of(final String userInput) {
        return new Cars(userInput);
    }

    public void tryMoveCars() {
        for (Car car : cars) {
            car.tryMove();
        }
    }

    @Override
    public String toString() {
        List<String> carStates = generateCarStates();
        return String.join(NEW_LINE.getSymbol(), carStates) + NEW_LINE.getSymbol();
    }

    private List<String> generateCarStates() {
        return cars.stream()
                .map(Car::toString)
                .toList();
    }

    public List<Car> findMaxPositionCars() {
        Integer maxPosition = findMaxPosition();
        return findSamePositionCars(maxPosition);
    }

    private List<Car> findSamePositionCars(final Integer maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    private Integer findMaxPosition() {
        return findCarWithMaxPosition().getPosition();
    }

    private Car findCarWithMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get();
    }

    private static class Validator {
        private static void validateCars(final List<Car> cars) {
            validateListSize(cars);
            validateDuplicateNames(cars);
        }

        private static void validateListSize(final List<Car> cars) {
            if (hasLessThanMinCars(cars)) {
                throw RaceException.of(INVALID_NAME_LIST_SIZE);
            }
        }

        private static boolean hasLessThanMinCars(final List<Car> cars) {
            return cars.size() < MIN_CAR_SIZE.getValue();
        }

        private static void validateDuplicateNames(final List<Car> cars) {
            if (hasDuplicateNames(cars)) {
                throw RaceException.of(DUPLICATE_NAME);
            }
        }

        private static boolean hasDuplicateNames(final List<Car> cars) {
            Integer uniqueSize = countUniqueCarNames(cars);
            return uniqueSize != cars.size();
        }

        private static Integer countUniqueCarNames(final List<Car> cars) {
            return cars.stream()
                    .map(Car::getName)
                    .collect(Collectors.toSet())
                    .size();
        }
    }
}