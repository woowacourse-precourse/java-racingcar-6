package racingcar.domain;

import static racingcar.message.MessageConstants.DELIMITER;
import static racingcar.message.MessageConstants.LINE_BREAK;
import static racingcar.message.MessageConstants.ZERO;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        duplicateValidationName(cars);
    }

    private void duplicateValidationName(List<String> name) {
        if (new HashSet<>(name).size() != name.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void move(PowerGenerator powerGenerator) {
        cars.forEach(car -> car.move(powerGenerator.generatorPower()));
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
