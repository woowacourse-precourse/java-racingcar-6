package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.stream.Collectors;

import static racingcar.constant.Delimiter.DELIMITER;

public class Judgement {

    public String determineWinners(final Racing racing) {
        Cars cars = racing.cars();
        int maxForwardCount = calculateMaxForwardCount(cars);

        return cars.cars()
                .stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER + " "));
    }

    private int calculateMaxForwardCount(final Cars cars) {
        return cars.cars()
                .stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }
}
