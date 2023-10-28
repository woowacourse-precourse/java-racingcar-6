package racingcar.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static racingcar.model.ExceptionMessage.DUPLICATE_CAR_GROUP_EXCEPTION_MESSAGE;
import static racingcar.model.ExceptionMessage.EMPTY_CAR_GROUP_EXCEPTION_MESSAGE;
import static racingcar.model.ExceptionMessage.EMPTY_WINNER_GROUP_EXCEPTION_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> cars;

    CarGroup(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validate(List<Car> cars) {
        validateEmpty(cars);
        validateDuplicates(cars);
    }

    private void validateEmpty(List<Car> cars) {
        if (isEmpty(cars)) {
            throw new IllegalArgumentException(EMPTY_CAR_GROUP_EXCEPTION_MESSAGE);
        }
    }

    private boolean isEmpty(List<Car> cars) {
        return cars.isEmpty();
    }

    private void validateDuplicates(List<Car> cars) {
        if (hasDuplicates(cars)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_GROUP_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicates(List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    public static CarGroup from(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .collect(collectingAndThen(toList(), CarGroup::new));
    }

    public CarWinners findWinners() {
        CarPosition maxPosition = findMaxPosition();
        return findCarsWithMaxPosition(maxPosition);
    }

    private CarPosition findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(CarPosition::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_WINNER_GROUP_EXCEPTION_MESSAGE));
    }

    private CarWinners findCarsWithMaxPosition(CarPosition maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(collectingAndThen(toList(), CarWinners::from));
    }

    public CarGroup moveAll(MovementCondition movementCondition) {
        return cars.stream()
                .map(car -> car.move(movementCondition))
                .collect(collectingAndThen(toList(), CarGroup::new));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
