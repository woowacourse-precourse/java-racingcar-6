package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.generator.NumberGenerator;

import java.util.stream.Collectors;

public record Racing(Cars cars) {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final String COLON_DELIMITER = " : ";
    private static final String HYPHEN = "-";
    private static final String LINE = "\n";

    public void runOneRound() {
        for (Car car : cars.cars()) {
            int randomValue = NumberGenerator.generateRandomNumber();
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
