package racingcar.domain.car;

import racingcar.domain.game.GameCondition;
import racingcar.dto.Car;

public class CarMovementDecider {
    private final CarMover carMover;

    public CarMovementDecider(Car car) {
        this.carMover = new CarMover(car);
    }

    public Integer decideMovement() {
        int movePosition;

        if (GameCondition.hasDriveCondition()) {
            movePosition = carMover.moveForward();
        } else {
            movePosition = carMover.stopMovement();
        }

        return movePosition;
    }
}