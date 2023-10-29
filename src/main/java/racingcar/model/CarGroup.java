package racingcar.model;

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
        long distinctCount = getDistinctCount(cars);
        return distinctCount != cars.size();
    }

    private long getDistinctCount(List<Car> cars) {
        return cars.stream()
                .distinct()
                .count();
    }

    public static CarGroup from(List<String> carNames) {
        List<Car> mappedCars = createCarsFromNames(carNames);
        return new CarGroup(mappedCars);
    }

    private static List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .collect(toList());
    }

    public CarWinners findWinners() {
        CarPosition maxPosition = findMaxPosition();
        List<Car> winners = findCarsWithMaxPosition(maxPosition);
        return CarWinners.from(winners);
    }

    private CarPosition findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(CarPosition::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_WINNER_GROUP_EXCEPTION_MESSAGE));
    }

    private List<Car> findCarsWithMaxPosition(CarPosition maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(toList());
    }

    public CarGroup moveAll(MovementCondition movementCondition) {
        List<Car> movedCars = moveCarsBasedOnCondition(movementCondition);
        return new CarGroup(movedCars);
    }

    private List<Car> moveCarsBasedOnCondition(MovementCondition movementCondition) {
        return cars.stream()
                .map(car -> car.move(movementCondition))
                .collect(toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
