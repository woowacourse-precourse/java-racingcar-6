package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.CAR_LIST_EMPTY;
import static racingcar.message.RacingCarErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.message.RacingCarErrorMessage.NOT_MIN_CAR_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RacingCarRandomMoveUtils;

public class Cars {

    private static final int CAR_COUNT_MINIMUM = 2;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        isDifferentCarName(cars);
        minimumCountOfCars(cars.size());
        this.cars = cars;
    }

    public void moveAll(final RacingCarRandomMoveUtils racingCarRandomMoveUtils) {
        for (final Car car : cars) {
            int engine = racingCarRandomMoveUtils.generateRandomNumber();
            car.move(engine);
        }
    }

    public List<String> findWinners() {
        Car maxDistanceCar = findMaxDistanceCar();
        List<String> winnerCarNameList = findSameDistanceList(maxDistanceCar);
        return winnerCarNameList;
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(CAR_LIST_EMPTY.getMessage()));
    }

    private List<String> findSameDistanceList(Car maxDistanceCar) {
        return cars.stream()
                .filter(maxDistanceCar::isSameDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private void isDifferentCarName(List<Car> cars) {
        List<String> carName = cars.stream()
                .map(idx -> idx.getCarName())
                .collect(Collectors.toList());

        HashSet<String> carNameDuplicateSet = new HashSet<>(carName);

        if (carNameDuplicateSet.size() != carName.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private void minimumCountOfCars(int size) {
        if (size < CAR_COUNT_MINIMUM) {
            throw new IllegalArgumentException(NOT_MIN_CAR_COUNT.getMessage());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
