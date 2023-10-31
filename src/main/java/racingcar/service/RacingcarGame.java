package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingcarGame {
    private static final int COUNT_ONE = 1;
    private static final int CRITERION_FOUR = 4;

    public List<String> createWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max = findMaxMoveForwardCount(cars);
        for (Car car : cars) {
            if (car.getMoveForwardCount() == max) {
                winner.add(car.getCarName());
            }
        }
        return winner;
    }

    private int findMaxMoveForwardCount(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getMoveForwardCount() > max) {
                max = car.getMoveForwardCount();
            }
        }
        return max;
    }

    public void increaseMoveForwardCount(Car car, int randomNumber) {
        if (randomNumber >= CRITERION_FOUR) {
            car.setMoveForwardCount(COUNT_ONE);
        }
    }
}
