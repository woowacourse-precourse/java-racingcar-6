package racingcar.domain.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {

    private static final int DEFAULT_POSITION = 0;

    public static List<Car> createCars(final List<String> carNames) {
        validateCarNames(carNames);
        return carNames.stream()
                .map(CarFactory::createCar)
                .collect(Collectors.toList());
    }

    private static void validateCarNames(final List<String> carNames) {
        isDistinct(carNames);
    }

    private static void isDistinct(final List<String> carNames) {
        Set<String> distinctCarNames = new HashSet<>(carNames);
        if (distinctCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private static Car createCar(final String carName) {
        return new Car(carName, DEFAULT_POSITION);
    }
}
