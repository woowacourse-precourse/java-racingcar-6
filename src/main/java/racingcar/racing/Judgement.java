package racingcar.racing;

import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.stream.Collectors;

import static racingcar.game.Constant.COMMA_DELIMITER;

public class Judgement {

    public String determineWinners(final Racing racing) {
        Cars cars = racing.cars();
        int maxForwardCount = calculateMaxForwardCount(cars);

        return cars.cars()
                .stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(COMMA_DELIMITER + " "));
    }

    private int calculateMaxForwardCount(final Cars cars) {
        return cars.cars()
                .stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }
}
