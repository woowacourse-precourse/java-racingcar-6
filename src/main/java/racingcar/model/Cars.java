package racingcar.model;

import java.util.Collections;
import java.util.List;
import racingcar.exception.car_racing_manager.NotExistCarException;
import racingcar.exception.car_racing_manager.NotUniqueCarNameException;
import racingcar.util.NumberGenerator;

public class Cars implements Vehicles {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createWith(final List<String> carNames) {
        validateNameDuplicate(carNames);
        validateCarExistence(carNames);
        return new Cars(convertToCarsFrom(carNames));
    }

    private static void validateNameDuplicate(final List<String> carNames) {
        if (hasDuplicate(carNames)) {
            throw new NotUniqueCarNameException(carNames);
        }
    }

    private static boolean hasDuplicate(final List<String> carNames) {
        int distinctCount = (int) carNames.stream()
                .distinct()
                .count();

        return distinctCount != carNames.size();
    }

    private static void validateCarExistence(final List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new NotExistCarException();
        }
    }

    private static List<Car> convertToCarsFrom(final List<String> carNames) {
        return carNames.stream()
                .map(Car::createWith)
                .toList();
    }

    @Override
    public void moveAll(final NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }

    @Override
    public List<String> getWinner() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NotExistCarException::new);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(cars);
    }
}
