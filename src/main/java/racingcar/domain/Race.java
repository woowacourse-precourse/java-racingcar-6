package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race (List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void oneRound() {
        move();
    }

    public void move() {
        for (Car car : cars) {
            if (moveStrategy.isAbleToMove()) {
                car.move();
            }
        }
    }

    public void printProgress() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generateProgressString(car));
        }
        System.out.println();
    }

    private String generateProgressString(Car car) {
        int position = car.getPosition();

        return "-".repeat(Math.max(0, position));
    }

    public String getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
            }

            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return String.join(",", winners);
    }
}
