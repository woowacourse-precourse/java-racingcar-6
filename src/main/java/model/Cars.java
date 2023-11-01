package model;

import static model.ErrorMessage.DUPLICATED_CAR_NAME;

import model.dto.MoveResult;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> values) {
        validateDuplicate(values);

        List<Car> cars = values.stream()
            .map(Car::from)
            .toList();

        return new Cars(cars);
    }

    public void actEachCar(final Consumer<Car> action) {
        cars.forEach(action);
    }

    public List<MoveResult> getMoveResult() {
        return cars.stream()
            .map(MoveResult::from)
            .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        List<Car> winners = getWinners();
        return winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.toList());
    }

    private static void validateDuplicate(final List<String> values) {
        long distinctSize = values.stream()
            .distinct()
            .count();

        if (distinctSize != values.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private List<Car> getWinners() {
        Car maxMoveCar = cars.stream()
            .max(Comparator.comparing(Car::getMoveCount))
            .orElseThrow(NoSuchElementException::new);

        return findSameMoveCountCars(maxMoveCar.getMoveCount());
    }

    private List<Car> findSameMoveCountCars(final MoveCount moveCount) {
        return cars.stream()
            .filter(car -> car.hasSameMoveCount(moveCount))
            .collect(Collectors.toList());
    }
}
