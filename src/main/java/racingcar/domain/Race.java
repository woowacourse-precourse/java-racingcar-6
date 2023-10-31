package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.ParserUtils;

public class Race {
    private ArrayList<Car> cars;
    private int attempt;

    public Race() {
        this.cars = new ArrayList<>();
    }

    public void advanceFullRound() {
        for (int round = 0; round < attempt; round++) {
            advanceOneRound();
            System.out.println();
        }
    }

    public void advanceOneRound() {
        for (Car car : cars) {
            car.moveForward();
            car.print();
        }
    }

    public void initializeRace(String attemptCountInput, String carNamesInput) {
        validateAttempt(attemptCountInput);
        parsePositiveInteger(attemptCountInput);
        initializeCar(carNamesInput);
    }

    public String selectWinners() {
        // Key=전진 횟수, Value=자동차의 이름
        Map<Integer, String> map = new HashMap<>();

        for (Car car : cars) {
            map.put(car.getMoveCount(),
                    map.getOrDefault(car.getMoveCount(), "") + ", " + car.getCarName());
        }

        Integer maxMoveCount = Collections.max(map.keySet());
        String winners = map.get(maxMoveCount).substring(2);

        return winners;
    }

    private void validateAttempt(String input) {
        validateNullOrBlank(input);
        validatePositiveInteger(input);
    }

    private void parsePositiveInteger(String input) {
        attempt = Integer.parseInt(input);
    }

    private void initializeCar(String carNamesInput) {
        List<String> carNameList = ParserUtils.namesParser(carNamesInput);

        for (String carName : carNameList) {
            Car car = new Car(carName);
            cars.add(car);
        }
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