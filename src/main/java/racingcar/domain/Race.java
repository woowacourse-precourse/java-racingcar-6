package racingcar.domain;

import java.util.stream.Collectors;

import static racingcar.constant.Constant.*;

public record Race(Cars cars) {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final String HYPHEN = "-"; // 각각의 차들이 달린 forwardCount 를 나타내는 hyphen
    private static final String COLON_DELIMITER = " : "; // pobi : --, 에서 " : " 를 나타내는 상수

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
