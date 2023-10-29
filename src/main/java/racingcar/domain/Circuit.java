package racingcar.domain;

import racingcar.util.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Circuit {

    public static final int MIN_PLAYER = 2;

    private final List<Car> cars;

    private Circuit(List<Car> cars) {
        this.cars = cars;
    }

    public static Circuit fromCarNames(List<String> carNames) {
        checkCarNameSize(carNames.size());
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Circuit(cars);
    }

    private static void checkCarNameSize(int size) {
        if (size < MIN_PLAYER) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_CAR_NAME_SIZE.getMessage());
        }
    }

    public List<Car> raceCars(List<MoveCondition> randomNumbers) {
        IntStream.range(0, getCircuitSize())
                .forEach(index -> cars.get(index).move(randomNumbers.get(index)));
        return cars;
    }

    public int getCircuitSize() {
        return this.cars.size();
    }

    public List<String> findTopPositionCarNames() {
        int maxPosition = getTopPosition();

        return cars.stream()
                .filter(car -> car.isEqualToPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getTopPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
