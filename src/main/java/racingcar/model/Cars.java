package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "중복된 이름을 입력하면 안 됩니다.";
    private static final String WINNER_DELIMITER = ", ";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public List<Car> move(RandomNumberGenerator randomNumberGenerator) {
        return cars.stream()
                .map(car -> car.move(randomNumberGenerator.generate()))
                .toList();
    }

    public String findWinners() {
        int maxLocationLength = getMaxLocationLength();
        return cars.stream()
                .filter(car -> car.getLocationLength() == maxLocationLength)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);

        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private int getMaxLocationLength() {
        return cars.stream()
                .mapToInt(Car::getLocationLength)
                .max()
                .orElse(0);
    }
}
