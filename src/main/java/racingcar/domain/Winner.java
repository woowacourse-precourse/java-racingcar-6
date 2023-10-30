package racingcar.domain;

import java.util.List;

public class Winner {
    static int maxValue = Integer.MIN_VALUE;

    static void checkWinner(List<Car> list) {
        for (Car car : list) {
            addWinner(car, GameManager.winner);
        }
    }

    private static void addWinner(Car car, List<String> winner) {
        if (winner.isEmpty() && getPosition(car) > maxValue) {
            winner.add(car.carName);
            maxValue = car.position;
        } else if (!winner.isEmpty() && getPosition(car) > maxValue) {
            winner.clear();
            winner.add(car.carName);
            maxValue = car.position;
        } else if (!winner.isEmpty() && getPosition(car) == maxValue) {
            winner.add(car.carName);
        }
    }

    private static int getPosition(Car car) {
        return car.position;
    }
}