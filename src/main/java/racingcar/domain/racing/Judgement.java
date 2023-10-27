package racingcar.domain.racing;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Delimiter.DELIMITER;

public class Judgement {

    public String determineWinners(final Racing racing) {
        List<Car> cars = racing.getCars();
        int maxForwardCount = calculateMaxForwardCount(cars);

        return cars.stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER + " "));
    }

    private int calculateMaxForwardCount(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }
}
