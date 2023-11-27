package racingcar.domain;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.exception.DomainConstraintsException;
import racingcar.domain.exception.DomainConstraintsExceptionMessage;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        validate(cars);
        return new Cars(cars);
    }

    private static void validate(List<Car> cars) {
        validateNotExistDuplication(cars);
    }

    private static void validateNotExistDuplication(List<Car> cars) {
        if (hasDuplication(cars)) {
            throw DomainConstraintsException.of(DomainConstraintsExceptionMessage.CAR_NAME_IS_DUPLICATED.getMessage());
        }
    }

    private static boolean hasDuplication(List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    public void race() {
        cars.forEach(
                Car::playOneTurn
        );
    }

    public Map<String, Integer> getCarNamesWithDistance() {
        Map<String, Integer> carNamesWithDistance = new LinkedHashMap<>();
        cars.forEach(
                car -> carNamesWithDistance.putAll(car.getNameWithDistance())
        );
        return carNamesWithDistance;
    }

    public List<String> findWinners() {
        Car winner = findMaxDistanceCar();
        return cars.stream()
                .filter(winner::isSameDistance)
                .map(Car::getName)
                .toList();
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(
                        () -> DomainConstraintsException.of(DomainConstraintsExceptionMessage.EMPTY_CARS.getMessage()));
    }
}