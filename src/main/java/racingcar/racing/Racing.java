package racingcar.racing;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.generator.RandomNumberGenerator;

import java.util.stream.Collectors;

import static racingcar.game.Constant.*;

public record Racing(Cars cars) {

    private static final int MIN_FORWARD_THRESHOLD = 4;

    public void runOneRound() {
        for (Car car : cars.cars()) {
            int randomValue = RandomNumberGenerator.generateRandomNumber();
            if (randomValue >= MIN_FORWARD_THRESHOLD) {
                car.forward();
            }
        }
    }

    public String displayRaceState() {
        return cars.cars()
                .stream()
                .map(car -> car.getName() + COLON_DELIMITER + generateHyphens(car.getForwardCount()))
                .collect(Collectors.joining(LINE));
    }

    private String generateHyphens(int forwardCount) {
        if (forwardCount <= 0) return "";
        return HYPHEN.repeat(forwardCount);
    }
}
