package racingcar.domain;

import java.util.stream.Collectors;

import static racingcar.constant.Constant.COMMA_DELIMITER;
import static racingcar.constant.Constant.SPACE;

public class Judgement {

    public String determineWinners(final Cars cars) {
        int maxForwardCount = calculateMaxPosition(cars);

        return cars.cars()
                .stream()
                .filter(car -> car.getPosition() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(COMMA_DELIMITER + SPACE));
    }

    private int calculateMaxPosition(final Cars cars) {
        return cars.cars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
