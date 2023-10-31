package racingcar.domain;

import java.util.List;

public class Referee {

    public Referee() {

    }

    public String selectWinner(List<Car> cars) {
        int maxMoveNum = getMaxMoveNum(cars);
        return getMaxMoveCars(cars, maxMoveNum);
    }

    private int getMaxMoveNum(List<Car> cars) {
        int maxMoveNum = 0;
        for (Car car : cars) {
            maxMoveNum = Math.max(maxMoveNum, car.getStatus().length());
        }
        return maxMoveNum;
    }

    private String getMaxMoveCars(List<Car> cars, int maxMoveNum) {
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            addWinner(maxMoveNum, car, winners);
        }
        return winners.toString();
    }

    private void addWinner(int maxMoveNum, Car car, StringBuilder winners) {
        if (car.getStatus().length() == maxMoveNum) {
            if (winners.isEmpty()) {
                winners.append(car.getName());
            } else {
                winners.append(", ");
                winners.append(car.getName());
            }
        }
    }
}
