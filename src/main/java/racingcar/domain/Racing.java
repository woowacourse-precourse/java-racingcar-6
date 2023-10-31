package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.PrintMessage;

public class Racing {
    private final List<Car> cars;
    private final int numberOfMoves;

    public Racing(List<Car> cars, int numberOfMoves) {
        this.cars = cars;
        this.numberOfMoves = numberOfMoves;
    }

    public void startGame() {
        for (int i = 0; i < numberOfMoves; i++) {
            moveCars();
            printGameResult();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    private void printGameResult() {
        for (Car car : cars) {
            PrintMessage.printGameResult(car.getName(), car.getPosition());
        }
        System.out.println(); // 각 턴 사이에 개행을 추가하여 결과가 분리되도록 합니다.
    }
    

    public List<String> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}

