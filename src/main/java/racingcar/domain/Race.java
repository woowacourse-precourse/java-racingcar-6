package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Race {
    private static final int ZERO = 0;
    private static final int WINNER_SUBSTRING = 2;

    private Cars cars;

    public Race() {
        this.cars = new Cars();
    }

    public Cars getCars() {
        return cars;
    }

    public void advanceFullRound(int attemptCount) {
        for (int round = ZERO; round < attemptCount; round++) {
            advanceOneRound();
            System.out.println();
        }
    }

    public void advanceOneRound() {
        for (Car car : cars.get()) {
            car.moveForward();
            car.print();
        }
    }

    public void initializeRace(String attemptCountInput, String carNamesInput) {
        validateAttempt(attemptCountInput);
        cars.initializeCar(carNamesInput);
    }

    public String selectWinners() {
        // Key=전진 횟수, Value=자동차의 이름
        Map<Integer, String> map = getIntegerStringMap();

        Integer maxMoveCount = Collections.max(map.keySet());
        String winners = map.get(maxMoveCount).substring(WINNER_SUBSTRING);

        return winners;
    }

    private Map<Integer, String> getIntegerStringMap() {
        Map<Integer, String> map = new HashMap<>();

        for (Car car : cars.get()) {
            map.put(car.getMoveCount(),
                    map.getOrDefault(car.getMoveCount(), "") + ", " + car.getCarName());
        }
        return map;
    }

    private void validateAttempt(String input) {
        validateNullOrBlank(input);
        validatePositiveInteger(input);
    }

    private void validateNullOrBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 회수는 공백일 수 없습니다.");
        }
    }

    private void validatePositiveInteger(String input) {
        if (!(input.matches("^[1-9]\\d*$"))) {
            throw new IllegalArgumentException("시도 회수는 양의 정수만 가능합니다.");
        }
    }
}