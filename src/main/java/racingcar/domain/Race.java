package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.ParserUtils;

public class Race {
    private ArrayList<Car> cars;
    private int attempt;

    public Race(String input) {
        validateAttempt(input);
        parsePositiveInteger(input);
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

    public void initializeCars(String input) {
        List<String> carNameList = ParserUtils.namesParser(input);

        for (String carName : carNameList) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private void parsePositiveInteger(String input) {
        attempt = Integer.parseInt(input);
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