package racingcar.domain;

import java.util.stream.Collectors;

import static racingcar.constant.Constant.COMMA_DELIMITER;

public class Judgement {

    public String determineWinners(final Race race) {
        Cars cars = race.cars();
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
