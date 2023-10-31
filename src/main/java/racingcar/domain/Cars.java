package racingcar.domain;

import static racingcar.global.constants.NumberType.MIN_CAR_SIZE;
import static racingcar.global.exception.ErrorMessage.DUPLICATE_NAME;
import static racingcar.global.exception.ErrorMessage.INVALID_NAME_LIST_SIZE;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.global.exception.RaceException;
import racingcar.utils.Parser;

public class Cars {
    private List<Car> carList;

    private Cars(final String userInput) {
        List<Car> cars = Parser.parseStringToCarList(userInput);
        Validator.validateCars(cars);
        this.carList = cars;
    }

    public static Cars of(final String userInput) {
        return new Cars(userInput);
    }

    public void tryMoveCars() {
        for (Car car : carList) {
            car.tryMove();
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Car car : carList) {
            result += car.toString() + "\n";
        }
        return result;
    }

    public List<Car> findMaxPositionCars() {
        Integer maxPosition = findMaxPosition();
        return findSamePositionCars(maxPosition);
    }

    private List<Car> findSamePositionCars(final Integer maxPosition) {
        return carList.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .toList();
    }

    private Integer findMaxPosition() {
        return findCarWithMaxPosition().getPosition();
    }

    private Car findCarWithMaxPosition() {
        return carList.stream()
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