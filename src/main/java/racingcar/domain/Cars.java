package racingcar.domain;

import static racingcar.message.MessageConstants.DELIMITER;
import static racingcar.message.MessageConstants.LINE_BREAK;
import static racingcar.message.MessageConstants.ZERO;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public String statusMessage() {
        return cars.stream()
                .map(Car::forwardStatus)
                .collect(Collectors.joining(LINE_BREAK));
    }

    public String winnerCars() {
        return cars.stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(ZERO, Integer::max);
    }

}
