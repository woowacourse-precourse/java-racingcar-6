package racingcar.service;

import static racingcar.constant.constantMessage.RESULT_MESSAGE;

import java.util.List;
import racingcar.domain.Car;

public class PlayRacingGame {
    public void play(long moveCount, List<Car> cars) {
        System.out.println("\n" + RESULT_MESSAGE);

        while (moveCount-- > 0) {
            moveCars(cars);
            printCarStatus(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.canMove()) {
                car.move();
            }
        }
    }

    private void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }
}
