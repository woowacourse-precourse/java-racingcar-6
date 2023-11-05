package racingcar.model;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameModel {

    private static final int CAR_NAMES_LIMIT = 5;

    private List<Car> cars;
    private int attempts;

    public RacingGameModel() {
    }

    public void moveCars() {
        for (Car car : cars) {
            car.randomMove();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCarNames(String carNames) {
        List<String> carNameList = new ArrayList<>(Arrays.asList(carNames.split(",")));
        cars = new ArrayList<>();
        for (String name : carNameList) {
            validateCarName(name);
            cars.add(new Car(name));
        }
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAMES_LIMIT || name.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름: " + name);
        }
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
