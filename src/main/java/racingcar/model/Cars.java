package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.NumberGenerator;

public class Cars {

    private static final int ZERO = 0;
    private static final String DUPLICATE_CAR_NAMES_MESSAGE = "중복된 차 이름이 있습니다.";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createFromCarNames(final List<String> carsName) {
        validateDuplicateNames(carsName);
        List<Car> cars = new ArrayList<>();
        for (final String carName : carsName) {
            cars.add(new Car(new Name(carName), Position.createDefault()));
        }
        return new Cars(cars);
    }

    private static void validateDuplicateNames(final List<String> carNames) {
        if (hasDuplicates(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAMES_MESSAGE);
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

    private List<String> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
