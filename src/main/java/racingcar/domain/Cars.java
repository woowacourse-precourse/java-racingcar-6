package racingcar.domain;

import static racingcar.exception.RacingCarExceptionMessage.DUPLICATED_CAR_NAMES;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> inputCarNames, CarEngine carEngine) {
        validateDuplicated(inputCarNames);
        List<Car> carList = inputCarNames.stream()
                .map(carName -> new Car(new CarName(carName), carEngine, new Position()))
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    private static void validateDuplicated(List<String> carNames) {
        int distinctCount = (int) carNames.stream()
                .distinct()
                .count();
        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES.getMessage());
        }
    }

    public void move() {
        cars.forEach(Car::startEngine);
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(car -> new Car(new CarName(car.getCarName()), car.getCarEngine(), new Position(car.getPosition())))
                .collect(Collectors.toUnmodifiableList());
    }
}
