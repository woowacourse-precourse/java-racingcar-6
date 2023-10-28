package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.config.GameConfig;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        validateMinLength(carNames);
        validateUniqueCarNames(carNames);
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private static void validateMinLength(List<String> carNames) {
        if (carNames.size() < GameConfig.CARS_MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateUniqueCarNames(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void moveAll(List<Integer> positions) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.moveForward(positions.get(i));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getSize() {
        return cars.size();
    }

    public List<String> getCarNamesByMaxPosition() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
