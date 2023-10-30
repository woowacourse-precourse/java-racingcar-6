package racingcar.model;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private static final String EMPTY_CAR_GROUP_EXCEPTION = "비어있는 자동차 목록으로 자동차 그룹을 만들 수 없습니다.";
    private static final String DUPLICATE_CAR_GROUP_EXCEPTION = "자동차 그룹에 중복된 이름이 존재합니다.";
    private static final String EMPTY_COMPARABLE_CAR_GROUP_EXCEPTION = "비교 가능한 자동차 목록이 비어있습니다.";

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
            throw new IllegalArgumentException(EMPTY_CAR_GROUP_EXCEPTION);
        }
    }

    private boolean isEmpty(List<Car> cars) {
        return cars.isEmpty();
    }

    private void validateDuplicates(List<Car> cars) {
        if (hasDuplicates(cars)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_GROUP_EXCEPTION);
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
        List<Car> cars = createCars(carNames);
        return new CarGroup(cars);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .collect(toList());
    }

    public Winners findWinners() {
        CarPosition maxPosition = findMaxPosition();
        List<Car> winners = findCarsWithMaxPosition(maxPosition);
        return Winners.from(winners);
    }

    private CarPosition findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(CarPosition::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_COMPARABLE_CAR_GROUP_EXCEPTION));
    }

    private List<Car> findCarsWithMaxPosition(CarPosition maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(toList());
    }

    public CarGroup moveAll(MovementCondition movementCondition) {
        List<Car> cars = moveCars(movementCondition);
        return new CarGroup(cars);
    }

    private List<Car> moveCars(MovementCondition movementCondition) {
        return cars.stream()
                .map(car -> car.move(movementCondition))
                .collect(toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
