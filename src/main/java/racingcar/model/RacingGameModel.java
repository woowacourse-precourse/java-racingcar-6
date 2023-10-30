package racingcar.model;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameModel {

    private static final int CAR_NAMES_LIMIT = 5;

    private List<Car> cars;

    public RacingGameModel(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            validateCarName(name);
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.goAdvance();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car);
            } else if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAMES_LIMIT || name.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름: " + name);
        }
    }
}
