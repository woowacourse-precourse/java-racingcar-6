package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.CommandLine.showln;

public class CarList {
    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }
    public void playRound(
            MoveForwardConditioner moveForwardConditioner
    ) {
        // 자동차 전진
        for (Car car : this.cars) {
            if (moveForwardConditioner.canMoveForward()) {
                car.moveForward();
            }
        }
        // 자동차 전진 show
        for (Car car : this.cars) {
            car.showCurrentMoveForward();
            showln("");
        }
        showln("");
    }
}
