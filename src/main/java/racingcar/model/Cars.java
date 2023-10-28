package racingcar.model;

import java.util.Collections;
import java.util.List;
import racingcar.exception.DuplicateCarNamesException;
import racingcar.util.NumberGenerator;

public class Cars {

    private static final int ZERO = 0;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> carNames) {
        validateDuplicateNames(carNames);
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }

    private static void validateDuplicateNames(final List<String> carNames) {
        if (hasDuplicates(carNames)) {
            throw new DuplicateCarNamesException();
        }
    }

    private static boolean hasDuplicates(final List<String> carNames) {
        long uniqueNamesCount = carNames.stream()
                .distinct()
                .count();

        return uniqueNamesCount != carNames.size();
    }

    public void moveAll(final NumberGenerator generator) {
        cars.forEach(car -> car.move(generator));
    }

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        return findWinners(maxPosition);
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(ZERO);
    }

    private List<String> findWinners(final int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
