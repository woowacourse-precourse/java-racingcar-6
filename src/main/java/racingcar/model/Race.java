package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class Race {
    private final CarList carList;
    private final List<String> winnerList;

    public Race(CarList carList) {
        this.carList = carList;
        this.winnerList = new ArrayList<>();
    }

    public void moveForward() {
        final int MOVE_CONDITION = 4;
        for (Car car : carList.getCarList()) {
            int number = RandomNumberGenerator.randomNumber();
            if (number >= MOVE_CONDITION) {
                car.move();
            }
        }
    }

    public List<String> checkWinner() {
        int maxMove = checkMaxMoveCount();
        for (Car car : carList.getCarList()) {
            if (car.getMoveCount() == maxMove) {
                winnerList.add(car.getCarName());
            }
        }
        return winnerList;
    }

    private int checkMaxMoveCount() {
        int maxMove = 0;
        for (Car car : carList.getCarList()) {
            if (car.getMoveCount() >= maxMove) {
                maxMove = car.getMoveCount();
            }
        }
        return maxMove;
    }

}