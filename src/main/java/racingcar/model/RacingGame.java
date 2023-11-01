package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}