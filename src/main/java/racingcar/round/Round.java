package racingcar.round;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;

import java.util.List;

public class Round {
    List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = cars;
    }

    public void startRound() {
        moveForward();
    }

    private void moveForward() {
        for (Car car : cars) {
            car.moveForwardOrNot(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
