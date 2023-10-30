package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final CarList carList;
    private final List<String> winner;
    public Race(CarList carList) {
        this.carList = carList;
        this.winner = new ArrayList<>();
    }

    public void moveForward() {
        for (Car car : carList.getCarList()) {
            if (RandomNumberGenerator.randomNumber() > 4) {
                car.move();
            }
        }
    }
    public List<String> checkWinner() {
        int maxMove = checkMaxMoveCount();
        for (Car car : carList.getCarList()) {
            if (car.getMoveCount() == maxMove) {
                winner.add(car.getCarName());
            }
            System.out.println(car.getCarName());
            System.out.println(car.getMoveCount());
        }
        return winner;
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